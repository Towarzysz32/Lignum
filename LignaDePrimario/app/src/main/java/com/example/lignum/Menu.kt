package com.example.lignum

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_menu.*
import org.json.JSONException
import java.net.URL


class Menu : AppCompatActivity() {

    private var poszukiwany: String ?= null
    private var poszukiwany_db: String ?= null
    private var pokaz: Intent?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)



        fun pokaz(){

            val queue = Volley.newRequestQueue(this)
            val url = "https://api.github.com/users/" + poszukiwany

            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        poszukiwany_db = response.get("login").toString()
             //////////////////////////////////////////////////////////////////
                        println("///////////////////////////////////////////////")
                        println("///////////////////////////////////////////////")
                        println("///////////////////////////////////////////////")
                        println(poszukiwany_db)

             ///////////////////////////////////////////////////////////////////
                        if (poszukiwany_db != null && poszukiwany_db == poszukiwany) {
                            pokaz = Intent(this, Pokaz::class.java)
                            startActivity(pokaz)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    } },
                Response.ErrorListener { error ->
                    "Nie udalo sie uzyc VOLLEYA".format(error.toString())
                })
            queue.add(jsonObjectRequest); }


        search.setOnClickListener {
            poszukiwany = Szukaj.text.toString()
            pobierzZmienna(poszukiwany!!)

            pokaz()
            println("----->>>> to jest pobrane z bazy - >>> " + poszukiwany_db + " <<<<<<--------")
            println("----->>>> to jest pobrane z szukaj - >>> " + poszukiwany + " <<<<<<--------")



            println("///////////////////////////////////////////////")
            println("///////////////////////////////////////////////")
            println("///////////////////////////////////////////////")
            println("///////////////////////////////////////////////")
        }

        LogOut.setOnClickListener {
            var dodaj = Intent(this, Wyswietl::class.java)
            startActivity(dodaj)
        }
        Add.setOnClickListener {
            var dodaj = Intent(this, Dodaj::class.java)
            startActivity(dodaj)
        }
        Map.setOnClickListener {
            var mapa = Intent(this, Mapa::class.java)
            startActivity(mapa)
        }
        User.setOnClickListener {
            var uzytkownik = Intent(this, Uzytkownik::class.java)
            startActivity(uzytkownik)
        }
        Reklama.setOnClickListener {
           var url: String = "http://www.google.com"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

    }

}
