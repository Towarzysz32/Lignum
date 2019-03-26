package com.example.lignum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_pokaz.*
import org.json.JSONException

class Pokaz : AppCompatActivity() {

    private var poszukiwanyPokaz: String ?= null
    private var nazwaPL: String ?= null
    private var nazwaLatina: String ?= null
    private var lokalizacja: String ?= null
    private var typ: String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokaz)

        fun pokaz(){

            val queue = Volley.newRequestQueue(this)
            val url = "http://192.168.0.101:8000/lignum/users/"+ nazwaPL

            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        nazwaPL = response.get("login").toString()
                        nazwaLatina = response.get("login").toString()
                        lokalizacja = response.get("location").toString()
                        typ = response.get("type").toString()
                        //////////////////////////////////////////////////////////////////
                        println("///////////////////////////////////////////////")
                        println("///////////////////////////////////////////////")
                        println("///////////////////////////////////////////////")
                        println(nazwaPL)
                        println(lokalizacja)
                        println(typ)

                        ///////////////////////////////////////////////////////////////////
                        if (nazwaPL != null && nazwaLatina != null && lokalizacja != null && typ != null) {


                            nazwa_drzewa_pl_db.text = nazwaPL
                            nazwa_drzewa_latina_db.text = nazwaLatina
                            lokalizacja_drzewa_db.text = lokalizacja
                            type_drzewa_db.text = typ

                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    } },
                Response.ErrorListener { error ->
                    "Nie udalo sie uzyc VOLLEYA".format(error.toString())
                })
            queue.add(jsonObjectRequest); }


            pokaz()



    }
}
