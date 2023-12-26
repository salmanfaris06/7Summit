package com.example.a7summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.a7summit.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    // Binding untuk Activity
    lateinit var binding: ActivityResetPasswordBinding

    // Instance dari FirebaseAuth untuk otentikasi pengguna
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate layout untuk Activity ini menggunakan binding
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Mendapatkan instance dari FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Menambahkan OnClickListener pada button reset password
        binding.btnReset.setOnClickListener {
            val email = binding.edtEmailReset.text.toString()
            val edtEmail = binding.edtEmailReset

            // Validasi email
            if (email.isEmpty()) {
                edtEmail.error = "Email Tidak Boleh Kosong"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            // Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                edtEmail.error = "Email Tidak Valid"
                edtEmail.requestFocus()
                return@setOnClickListener
            }

            // Mengirim email reset password menggunakan Firebase Authentication
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {

                if (it.isSuccessful){
                    // Jika pengiriman email reset password berhasil, tampilkan pesan toast
                    Toast.makeText(this, "Email Reset Password Telah Dikirim", Toast.LENGTH_SHORT).show()
                    // Pindah ke halaman login
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Jika pengiriman email reset password gagal, tampilkan pesan error
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}
