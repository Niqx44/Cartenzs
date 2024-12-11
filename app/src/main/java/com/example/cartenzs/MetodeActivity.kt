package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MetodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_metode_page)

        val kembali = findViewById<LinearLayout>(R.id.kembalihome)
        kembali.setOnClickListener {
            val intent = Intent(this, PembayaranActivity::class.java)
            startActivity(intent)

        }

        val selanjutnya = findViewById<LinearLayout>(R.id.selanjutnya)
        selanjutnya.setOnClickListener {
            val intent = Intent(this, PaymentNotifActivity::class.java)
            startActivity(intent)

        }
    }
}