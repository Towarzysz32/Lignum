package com.example.lignum


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_rejestracja.*
import org.json.JSONException
import org.json.JSONObject









class Rejestracja : AppCompatActivity() {

    private var login: String? = null
    private var password: String? = null

    fun rejestrowanie_uzytkownika(login: String,password: String){

        val jsonobj = JSONObject()
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users"

        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Rejestracja    =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+    Login = $login                =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+    Emial = $password             =+=+=+=+=+=+=+=+=+=+")




        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonobj,
            Response.Listener {response ->
                try {
                    jsonobj.put("login", login)
                    jsonobj.put("email", password)

                    // Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()
                    println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                    println(" =+=+=+=+=+=+=+=+=+=+       UDALO SIE      =+=+=+=+=+=+=+=+=+=+")
                    println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")

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
        setContentView(R.layout.activity_rejestracja)





        EditPassword(new_password,info_password)
        TestPassword(new_password,new_password_second,info_second_password)


       new_register.setOnClickListener {
           login = new_login.text.toString()
           password = new_email.text.toString()

           rejestrowanie_uzytkownika(login!!, password!!)
        }
    }
}
///////////////////////////////////////////







