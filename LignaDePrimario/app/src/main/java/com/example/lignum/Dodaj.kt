package com.example.lignum


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.PointF
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_dodaj.*
import org.json.JSONException
import org.json.JSONObject
import android.location.Geocoder
import com.google.android.gms.maps.SupportMapFragment
import java.util.*


class Dodaj : AppCompatActivity() {

    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var mLocation: Location

    object Constants {
        const val SUCCESS_RESULT = 0
        const val FAILURE_RESULT = 1
        const val PACKAGE_NAME = "com.google.android.gms.location.sample.locationaddress"
        const val RECEIVER = "$PACKAGE_NAME.RECEIVER"
        const val RESULT_DATA_KEY = "${PACKAGE_NAME}.RESULT_DATA_KEY"
        const val LOCATION_DATA_EXTRA = "${PACKAGE_NAME}.LOCATION_DATA_EXTRA"
    }

    fun nowe_drzewo(){

        val jsonobj = JSONObject()
        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.101:8000/lignum/users"

        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Rejestracja    =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                   =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                =+=+=+=+=+=+=+=+=+=+")




        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonobj,
            Response.Listener { response ->
                try {
                  //  jsonobj.put("login", )
                  //  jsonobj.put("email", )

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




    @SuppressLint("MissingPermission")       // <---------------    udziel pozwolenia lokalizacji
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dodaj)



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val addOnSuccessListener = fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->

                if (location != null) {
                    // Logic to handle location object
                    mLocation = location;
                    wspolrzedna_x.text = "Szerokosc " + mLocation.latitude
                    wspolrzedna_y.text = "Dlugosc " + mLocation.longitude
                  //  fusedLocationClient.getFromLocation(mLocation.latitude,mLocation.longitude,1)

                } else {
                    wspolrzedna_x.text = "Error"
                    wspolrzedna_y.text = "Error"
                }
            }



        fun onHandleIntent(intent: Intent?) {
            val geocoder = Geocoder(this, Locale.getDefault())
            // ...
        }


        camera.setOnClickListener {

        }






                                                        }
    }
