package com.example.lignum



import android.annotation.SuppressLint
import android.content.Intent
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
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*



class Dodaj : AppCompatActivity() {

    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var mLocation: Location
    @RequiresApi(Build.VERSION_CODES.O)
    val current = LocalDateTime.now()

    private var name_polish: String? = null
    private var name_latin: String? = null
    private var location: String? = null
    private var street: String? = null
    private var city: String? = null
    private var location_longitude: Double?= null
    private var location_latitude: Double? = null
    private var description: String? = null
    private var adddate_string: String? = null
    private var blocked: Date? = null
    private var adddate: LocalDateTime? = null
    private var is_pomnik: String? = null
    private var in_greenhouse: String? = null
    private var unknown_tree: String? = null
    private var nonexistent: String? = null
    private var view_count: String? = null
    private var post_on_fb: String? = null
    private var location_longitude_string: String? = null
    private var location_latitude_string: String? = null

 @RequiresApi(Build.VERSION_CODES.O)
 fun przypisanie_wartosci(){
        location_longitude =  mLocation.longitude
        location_latitude =  mLocation.latitude
      //  adddate =  current
        location_longitude_string = location_longitude.toString()
        location_latitude_string = location_latitude.toString()
        adddate_string = adddate.toString()
        name_polish = nazwa_pl_editText.text.toString()
        name_latin = nazwa_la_editText.text.toString()
        location = nazwa_miejsca_edit.text.toString()
        street = adres_edit.text.toString()
        city = wojewodztwo_edit.text.toString()
        description = opis_editText.text.toString()
 }


    fun checkBoxIsChecked(){
        fun pomnik(pomnik: String): String {
            when (checkBoxPomni.isChecked) {
                true -> return "YES"
                false -> return "NO"
            }
        }
        fun greenhouse(greenhouse: String): String {
            when (checkBoxGreenhouse.isChecked) {
                true -> return "YES"
                false -> return "NO"
            }
        }
        fun unknown_tree(unknown_tree: String): String {
            when (checkBoxUnknownTree.isChecked) {
                true -> return "YES"
                false -> return "NO"
            }
        } }














    @RequiresApi(Build.VERSION_CODES.O)
    private fun nowe_drzewo(){

    val jsonobj = JSONObject()
        przypisanie_wartosci()
      //  checkBoxIsChecked()
        jsonobj.put("name_polish", name_polish )
        jsonobj.put("name_latin", name_latin)
        jsonobj.put("location", location)
        jsonobj.put("street", street)
        jsonobj.put("city", city )
        jsonobj.put("location_longitude", location_longitude_string )
        jsonobj.put("location_latitude", location_latitude_string)
      //  jsonobj.put("description", description )
        jsonobj.put("blocked", blocked)
       // jsonobj.put("adddate", adddate)
       // jsonobj.put("is_pomnik", is_pomnik)
      //  jsonobj.put("in_greenhouse", in_greenhouse)
      //  jsonobj.put("unknown_tree", unknown_tree)
      //  jsonobj.put("nonexistent", nonexistent)

    val queue = Volley.newRequestQueue(this)
    val url = "http://192.168.0.101:8000/lignum/tree"

        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+   WCHODZIMY W TRY Rejestracja    =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+                                  =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ name_polish = $name_polish =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ name_latin = $name_latin =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ location = $location =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ street = $street =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ city = $city =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ location_longitude = $location_longitude =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ location_latitude = $location_latitude =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ description = $description =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ blocked = $blocked =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ adddate = $adddate =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ is_pomnik = $is_pomnik =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ in_greenhouse = $in_greenhouse =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ unknown_tree = $unknown_tree =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ nonexistent = $nonexistent =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ view_count = $view_count =+=+=+=+=+=+=+=+=+=+")
        println(" =+=+=+=+=+=+=+=+=+=+ post_on_fb = $post_on_fb =+=+=+=+=+=+=+=+=+=+")


    val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, jsonobj,
        Response.Listener { response ->
            try {


                println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+       UDALO SIE      =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+                      =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ name_polish = $name_polish =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ name_latin = $name_latin =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ location = $location =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ street = $street =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ city = $city =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ location_longitude = $location_longitude =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ location_latitude = $location_latitude =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ description = $description =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ blocked = $blocked =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ adddate = $adddate =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ is_pomnik = $is_pomnik =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ in_greenhouse = $in_greenhouse =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ unknown_tree = $unknown_tree =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ nonexistent = $nonexistent =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ view_count = $view_count =+=+=+=+=+=+=+=+=+=+")
                println(" =+=+=+=+=+=+=+=+=+=+ post_on_fb = $post_on_fb =+=+=+=+=+=+=+=+=+=+")

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


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingPermission", "SetTextI18n")       // <---------------    udziel pozwolenia lokalizacji
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

        camera.setOnClickListener {

        }
        zapisz_nowe_drzewo.setOnClickListener {
            nowe_drzewo()
        }






                                                        }
    }
