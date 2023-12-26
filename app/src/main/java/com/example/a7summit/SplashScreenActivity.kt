package com.example.a7summit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengatur layout untuk Activity ini
        setContentView(R.layout.activity_splash_screen)

        // Handler digunakan untuk menjalankan suatu tindakan setelah jeda waktu tertentu
        val handler = Handler()

        // PostDelayed digunakan untuk menjalankan suatu tindakan setelah jeda waktu tertentu
        handler.postDelayed({
            // Membuat Intent untuk pindah ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)

            // Memulai aktivitas baru (pindah ke LoginActivity)
            startActivity(intent)

            // Menutup SplashScreenActivity agar tidak dapat kembali ke halaman ini saat tombol back ditekan
            finish()
        }, 3000) // Jeda waktu 3000 milidetik (3 detik)
    }
}
