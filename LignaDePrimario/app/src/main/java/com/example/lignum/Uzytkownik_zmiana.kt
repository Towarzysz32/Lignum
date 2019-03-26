package com.example.lignum

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_uzytkownik_zmiana.*
import org.json.JSONException
import org.json.JSONObject


class Uzytkownik_zmiana : AppCompatActivity() {

    private var login: String? = null
    private var password: String? = null
    private var email: String? = null

    fun zmiana_danych_uzytkownika(){

        val jsonobj = JSONObject()
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users"

                                                                    println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Rejestracja    =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.PUT, url, jsonobj,
            Response.Listener { response ->
                try {
                      jsonobj.put("login", login )
                      jsonobj.put("passsword", password)
                      jsonobj.put("email", email)

                                                                    println(" =+=+=+=+=+=+=+=+=+=+ login = $login       =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+ password = $password =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+ email = $email       =+=+=+=+=+=+=+=+=+=+")

                } catch (e: JSONException) {
                    e.printStackTrace()
                }


            },
            Response.ErrorListener { error ->
                "Nie udalo sie uzyc VOLLEYA - POSY".format(error.toString())

                                                                    println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+   Nie udalo sie      =+=+=+=+=+=+=+=+=+=+")
                                                                    println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
            })

        queue.add(jsonObjectRequest);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uzytkownik_zmiana)

        zapisz_zmiana_uzytkownik.setOnClickListener {
            var uzytkownik_po_zmianie = Intent(this, Uzytkownik::class.java)

            zmiana_danych_uzytkownika()

            startActivity(uzytkownik_po_zmianie)

        }
    }
}
