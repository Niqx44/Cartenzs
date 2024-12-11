package com.example.cartenzs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.LinearLayout
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.cartenzs.databinding.ActivityLoginPageBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider


class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityLoginPageBinding
    private lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        findViewById<LinearLayout>(R.id.googlebutton).setOnClickListener {
            signInGoogle()
        }


        binding.textviewsignup.setOnClickListener {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }

        binding.buttonmasuk.setOnClickListener {
            val password = binding.passwordlogin.text.toString()
            val email = binding.emaillogin.text.toString()

            if (email.isEmpty()) {
                binding.emaillogin.error = "Email Harus Diisi"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emaillogin.error = "Email Tidak Valid"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordlogin.error = "Password Harus Diisi"
                binding.passwordlogin.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email, password)
            
        }

    }

    private fun signInGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
                if (result.resultCode == Activity.RESULT_OK){

                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleResult(task)
                }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            if (account != null){
                updateUI(account)
            }

        }else{
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                val intent7 : Intent = Intent(this, Main2Activity::class.java)
                startActivity(intent7)
            }else{
                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Main2Activity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }

    }
}

