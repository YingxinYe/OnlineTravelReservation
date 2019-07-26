package com.example.online_travel_reservation_.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.online_travel_reservation_.R
import android.content.SharedPreferences
import com.example.online_travel_reservation_.fragments.LoginFragment


class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE)
        val apikey = sharedPreferences.getString("APIKEY", null)
        if (apikey != null) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            supportFragmentManager.beginTransaction().add(R.id.login_fragment_container, LoginFragment()).commit()
        }
    }
}
