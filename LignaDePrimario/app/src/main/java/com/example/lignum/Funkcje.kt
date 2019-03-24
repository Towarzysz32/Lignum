package com.example.lignum

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

lateinit var pomocnicza: String
fun EditPassword(password: EditText, error_login: TextView) {
    password.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable?) {
            if (password.length() == 0)
                error_login.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (password.length() <= 4) {
                error_login.setText("Haslo za krotkie")
                error_login.visibility = TextView.VISIBLE
            } else if (password.length() > 4 && password.length() <= 7) {
                error_login.setText("Haslo za proste")
                error_login.visibility = TextView.VISIBLE
            } else if (password.length() >= 8) {
                error_login.setText("DOBRE")
                error_login.visibility = TextView.VISIBLE
            } }
    })
}
fun TestPassword (new_password: EditText, second_password: EditText, error_login: TextView){

    second_password.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable?) {
            if (error_login.length() == 0)
                error_login.visibility = TextView.INVISIBLE
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int){
            if(second_password == new_password){
                error_login.setText("DOBRE")
                error_login.visibility = TextView.VISIBLE
            }
            else {
                error_login.setText("Haslo niepoprawne")
                error_login.visibility = TextView.VISIBLE


            }}
    })
}

fun pobierzZmienna(zmienna: String): String {
    pomocnicza = zmienna
    return zmienna
}
fun wyswietl(): String? {
    val poszukiwany: String
    poszukiwany = pomocnicza
    return poszukiwany
}