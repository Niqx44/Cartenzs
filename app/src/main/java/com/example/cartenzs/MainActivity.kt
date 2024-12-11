package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        var buttonmasuk = findViewById<Button>(R.id.buttonmasuk)
        buttonmasuk.setOnClickListener {
            val intent1 = Intent (this, Main2Activity::class.java)
            startActivity(intent1)

        var daftar = findViewById<TextView>(R.id.textviewsignup)
        daftar.setOnClickListener {
            val intent2 = Intent (this,SigninActivity::class.java)
            startActivity(intent2)
        }

        }
    }
}

