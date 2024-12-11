package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin_page)

        var daftar = findViewById<Button>(R.id.daftar)
        daftar.setOnClickListener {
            val intent3 = Intent(this, Main2Activity::class.java)
            startActivity(intent3)
        }

        var daftar1 = findViewById<TextView>(R.id.textviewsignup)
        daftar1.setOnClickListener {
            val intent4 = Intent(this, MainActivity::class.java)
            startActivity(intent4)
        }

    }
}