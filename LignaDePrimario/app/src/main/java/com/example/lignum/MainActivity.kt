package com.example.lignum

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import com.android.volley.RequestQueue




class MainActivity : AppCompatActivity() {
    private var login: String? = null
    private var password: String? = null
    private var password_db: String? = null
    private var login_db: String? = null
    private var rejestracja: Intent? = null
    private var menu: Intent? = null

    private fun dupa(){
        println("mam dupe")}

    private fun logowanie(login: String?, password: String?){

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users/$login"



        println(" =+=+=+=+=+=+=+=+=+=+                                   =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY MainActivity    =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                                   =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
        println("                   < login = $login == $login_db > ")
        println("                   < password = $password == $password_db > ")
        println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    password_db = response.get("email").toString()
                    login_db = response.get("login").toString()

                    //////////////////////////////////////////////////////////////////

                    println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")
                    println("               < login = $login == $login_db > ")
                    println("               < password = $password == $password_db > ")
                    println(" =+=+=+=+=+=+=+=+=+=+                    =+=+=+=+=+=+=+=+=+=+")

                    ///////////////////////////////////////////////////////////////////

                    if (login_db == login || password_db == password) {
                        menu = Intent(this, Menu::class.java)
                        startActivity(menu)
                    } else {
                        error_login.visibility = TextView.VISIBLE
                        if (login_db != login && password_db == password || login_db != null)
                            error_login.text = "Nieprawidłowy login"
                        else if (login_db == login && password_db != password || password_db != null)
                            error_login.text = "Nieprawidłowe  hasło"
                        else if (login_db != login && password_db != password)
                            error_login.text = "Nieprawidłowy logi albo hasło"
                        else if (login_db == null || password_db == null)
                            error_login.text = "Cos jest nie tak"
                    }

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



 ///////////////////////////////////////////////////////////////    onCreate       /////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        log_in.setOnClickListener {
            login = account_login.text.toString()
            password = account_password.text.toString()
            menu = Intent(this, Menu::class.java)
            startActivity(menu)
            dupa()

          //  logowanie(login, password)

            if (login_db == login || password_db == password) {
                menu = Intent(this, Menu::class.java)
                startActivity(menu)
            }
        }
        register.setOnClickListener {
            rejestracja = Intent(this, Rejestracja::class.java)
            startActivity(rejestracja)
        }
    }
}





