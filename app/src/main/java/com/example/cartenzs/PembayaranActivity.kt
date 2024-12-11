package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PembayaranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pembayaran)

        val kembali = findViewById<LinearLayout>(R.id.kembalihome)
        kembali.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }

        val selanjutnya = findViewById<LinearLayout>(R.id.selanjutnya)
        selanjutnya.setOnClickListener {
            val intent = Intent(this, MetodeActivity::class.java)
            startActivity(intent)

        }
    }
}