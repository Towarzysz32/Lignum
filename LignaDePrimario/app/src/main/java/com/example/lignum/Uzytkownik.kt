package com.example.lignum

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_uzytkownik.*

class Uzytkownik : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uzytkownik)

        edit_edit_user.setOnClickListener {
            var edit_user = Intent(this, Uzytkownik_zmiana::class.java)
            startActivity(edit_user)
        }
    }
}