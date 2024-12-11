package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentNotifActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_notif)

        val selanjutnya = findViewById<LinearLayout>(R.id.selanjutnya)
        selanjutnya.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)

        }

    }
}