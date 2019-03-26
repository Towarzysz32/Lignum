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


class Menu : AppCompatActivity() {

    private var poszukiwany: String?= null
    private var poszukiwany_db: String?= null
    private var pokaz: Intent?= null


    fun znajdz(poszukiwany: String?){

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users/$poszukiwany"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                   poszukiwany_db = response.get("login").toString()
                                                        //////////////////////////////////////////////////////////////////
                                                        println(" =+=+=+=+=+=+=+=+=+=+                               =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+         $poszukiwany_db       =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+                               =+=+=+=+=+=+=+=+=+=+")
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


    ///////////////////////////////////////////////////////////////    onCreate       /////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        search.setOnClickListener {
            poszukiwany = Szukaj_baza_danych.text.toString()


            znajdz(poszukiwany)
            println(" =+=+=+=+=+=+=+=+=+=+                                              =+=+=+=+=+=+=+=+=+=+")
            println(" =+=+=+=+=+=+=+=+=+=+       pobrane z bazy -> $poszukiwany_db      =+=+=+=+=+=+=+=+=+=+")
            println(" =+=+=+=+=+=+=+=+=+=+       pobrane z szukaj -> $poszukiwany       =+=+=+=+=+=+=+=+=+=+")
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
            var users_string: String? = intent.getStringExtra("Menu")

            uzytkownik!!.putExtra("Uzytkownik", users_string)
            println(" =+=+=+=+=+=+=+=+=+=+            $uzytkownik                               =+=+=+=+=+=+=+=+=+=+")
            startActivity(uzytkownik)
        }
        Reklama.setOnClickListener {
           var url: String = "http://www.google.com"
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }



    }

}
