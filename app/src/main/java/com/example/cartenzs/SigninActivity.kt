package com.example.cartenzs

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cartenzs.databinding.ActivitySigninPageBinding
import com.google.firebase.auth.FirebaseAuth

class SigninActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivitySigninPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySigninPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.textviewsignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.daftar.setOnClickListener {

            val nama = binding.nama.text.toString()
            val username = binding.username.text.toString()
            val email = binding.akunemail.text.toString()
            val password = binding.katasandinya.text.toString()
            val konfirmasi = binding.konfirmasi.text.toString()

            if (nama.isEmpty()) {
                binding.nama.error = "Nama Harus Diisi"
                binding.nama.requestFocus()
                return@setOnClickListener
            }

            if (username.isEmpty()) {
                binding.username.error = "Username Harus Diisi"
                binding.username.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.akunemail.error = "Email Harus Diisi"
                binding.akunemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.akunemail.error = "Email Tidak Valid"
                binding.akunemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.katasandinya.error = "Password Harus Diisi"
                binding.katasandinya.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 8) {
                binding.katasandinya.error = "Password Minimal 8 Karakter"
                binding.katasandinya.requestFocus()
                return@setOnClickListener
            }

            if (password != konfirmasi) {
                binding.konfirmasi.error =
                    "Password dan Konfirmasi Password Tidak Sama"
                binding.konfirmasi.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email, password)

        }

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }
}