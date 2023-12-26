package com.example.a7summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.a7summit.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    // Binding untuk Activity
    lateinit var binding: ActivityRegisterBinding

    // Instance dari FirebaseAuth untuk otentikasi pengguna
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate layout untuk Activity ini menggunakan binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Mendapatkan instance dari FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Menambahkan OnClickListener pada TextView untuk kembali ke halaman login
        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Menambahkan OnClickListener pada button register
        binding.btnRegister.setOnClickListener {
            val email = binding.edtEmailRegister.text.toString()
            val password = binding.edtPasswordRegister.text.toString()

            // Validasi email
            if (email.isEmpty()) {
                binding.edtEmailRegister.error = "Email Harus Diisi"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            // Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmailRegister.error = "Email Tidak Valid"
                binding.edtEmailRegister.requestFocus()
                return@setOnClickListener
            }

            // Validasi password
            if (password.isEmpty()) {
                binding.edtPasswordRegister.error = "Password Harus Diisi"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            // Validasi panjang password
            if (password.length < 8) {
                binding.edtPasswordRegister.error = "Password Minimal 8 Karakter"
                binding.edtPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            // Memanggil fungsi RegisterFirebase dengan email dan password
            RegisterFirebase(email, password)
        }
    }

    // Fungsi untuk mendaftarkan pengguna ke Firebase
    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    // Registrasi berhasil, tampilkan pesan toast dan pindah ke halaman login
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // Registrasi gagal, tampilkan pesan error
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
