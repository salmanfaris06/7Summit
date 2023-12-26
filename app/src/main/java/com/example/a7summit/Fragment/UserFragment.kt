package com.example.a7summit.Fragment

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.a7summit.LoginActivity
import com.example.a7summit.R
import com.example.a7summit.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream

class UserFragment : Fragment() {

    // Binding untuk Fragment
    private var _binding: FragmentUserBinding? = null
    lateinit var auth: FirebaseAuth
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk Fragment ini menggunakan binding
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Fungsi yang dipanggil saat Fragment dihancurkan untuk mencegah memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    // Fungsi untuk menangani proses logout
    private fun successLogout() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()

        // Membuat Intent untuk berpindah ke halaman LoginActivity
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)

        // Menutup activity saat ini
        activity?.finish()

        // Menampilkan pesan toast untuk memberi informasi ke pengguna
        Toast.makeText(activity, "Silahkan Login Kembali", Toast.LENGTH_SHORT).show()
    }

    // Fungsi yang dipanggil setelah tampilan Fragment telah dibuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        // Kondisi: Jika pengguna sedang login, set teks pada EditText dengan email pengguna
        if (user != null) {
            binding.edtEmail.setText(user.email)
        }

        // Menambahkan listener pada button logout untuk memanggil fungsi successLogout
        binding.btnLogout.setOnClickListener {
            successLogout()
        }
    }
}
