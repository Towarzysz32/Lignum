package com.example.lignum

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_uzytkownik.*
import org.json.JSONException

class Uzytkownik : AppCompatActivity() {

    private var login_db: String? = null
    private var login: String? = null
    private var password_db: String? = null
    private var email_db: String? = null
    private var pomocnicza_uzytkownik: String? = null



    private fun pokaz_uzytkownik(pomocnicza_uzytkownik: String?){

            val queue = Volley.newRequestQueue(this)
            val url = "http://192.168.0.101:8000/lignum/users/$pomocnicza_uzytkownik"



            println(" =+=+=+=+=+=+=+=+=+=+                                   =+=+=+=+=+=+=+=+=+=+")
            println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Uzytkownik      =+=+=+=+=+=+=+=+=+=+")
            println(" =+=+=+=+=+=+=+=+=+=+                                   =+=+=+=+=+=+=+=+=+=+")
            println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
            println("                   < login = $login_db > ")
            println("                   < password = $password_db > ")
            println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")

            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        password_db = response.get("password").toString()
                        login_db = response.get("login").toString()
                        email_db = response.get("email").toString()

                        //////////////////////////////////////////////////////////////////
                        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
                        println("               < login = $login_db > ")
                        println("               < password = $password_db > ")
                        println("               < email_db = $email_db > ")
                        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
                        Login_user_view.text = login_db
                        Password_user_view.text = password_db
                        Email_user_view.text = email_db
                        ///////////////////////////////////////////////////////////////////



                    } catch (e: JSONException) {
                        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
                        println(" =+=+=+=+=+=+=+=+=+=+         BLAD       =+=+=+=+=+=+=+=+=+=+")
                        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
                        e.printStackTrace()
                    }

                },
                Response.ErrorListener { error ->
                    "Nie udalo sie uzyc VOLLEYA".format(error.toString())
                })
            queue.add(jsonObjectRequest)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uzytkownik)


        pomocnicza_uzytkownik = intent.getStringExtra("Uzytkownik")
        println(" =+=+=+=+=+=+=+=+=+=+      $pomocnicza_uzytkownik              =+=+=+=+=+=+=+=+=+=+")
        pokaz_uzytkownik(pomocnicza_uzytkownik)

        edit_edit_user.setOnClickListener {
            var edit_user = Intent(this, Uzytkownik_zmiana::class.java)
            startActivity(edit_user)
        }
    }
}