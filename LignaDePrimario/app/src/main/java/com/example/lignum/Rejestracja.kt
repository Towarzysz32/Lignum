package com.example.lignum




import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
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
    private var email: String? = null

    fun TestPassword (new_password: EditText, second_password: EditText, error_login: TextView){

        second_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (error_login.length() == 0)
                    error_login.visibility = TextView.INVISIBLE
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
                if(second_password == new_password){
                    error_login.text = "DOBRE"
                    error_login.visibility = TextView.VISIBLE
                }
                else {
                    error_login.text = "Haslo niepoprawne"
                    error_login.visibility = TextView.VISIBLE


                }}
        })
    }

    private fun EditPassword(password: EditText, error_login: TextView) {
        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (password.length() == 0)
                    error_login.visibility = TextView.INVISIBLE
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (password.length() <= 4) {
                    error_login.text = "Haslo za krotkie"
                    error_login.visibility = TextView.VISIBLE
                } else if (password.length() in 5..7) {
                    error_login.text = "Haslo za proste"
                    error_login.visibility = TextView.VISIBLE
                } else if (password.length() >= 8) {
                    error_login.text = "DOBRE"
                    error_login.visibility = TextView.VISIBLE
                } }
        })
    }

    private fun rejestrowanie_uzytkownika(login: String, password: String, email: String){

        val jsonobj = JSONObject()
        jsonobj.put("login", login)
        jsonobj.put("password", password)
        jsonobj.put("email", email)

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users"

                                                        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Rejestracja    =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Login = $login                =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Password = $password          =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Emial = $email                =+=+=+=+=+=+=+=+=+=+")


        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, jsonobj,
            Response.Listener { response ->
                try {




                                                        println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+       UDALO SIE      =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Login = $login                =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Password = $password             =+=+=+=+=+=+=+=+=+=+")
                                                        println(" =+=+=+=+=+=+=+=+=+=+    Emial = $email             =+=+=+=+=+=+=+=+=+=+")

                       val  menu = Intent(this, MainActivity::class.java)
                        startActivity(menu)



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

        queue.add(jsonObjectRequest)
    }

    ///////////////////////////////////////////////////////////////    onCreate       /////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rejestracja)


           // EditPassword(new_password,info_password)
            //TestPassword(new_password,new_password_second,info_second_password)


       new_register.setOnClickListener {
           login = new_login.text.toString()
           password = new_password.text.toString()
           email = new_email.text.toString()

           rejestrowanie_uzytkownika(login!!, password!!,email!!)

        }
    }
}
///////////////////////////////////////////







