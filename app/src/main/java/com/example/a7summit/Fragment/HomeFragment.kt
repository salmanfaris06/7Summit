package com.example.a7summit.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.a7summit.PembayaranActivity
import com.example.a7summit.PembayaranActivity.Companion.DATA_HARGA
import com.example.a7summit.PembayaranActivity.Companion.DATA_NAMA
import com.example.a7summit.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk Fragment ini
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Inisialisasi button-button yang ada di dalam layout
        val btnMerapi: Button = rootView.findViewById(R.id.btn_merapi)
        val btnApiPurba: Button = rootView.findViewById(R.id.btn_apiPurba)
        val btnSindoro: Button = rootView.findViewById(R.id.btn_Sindoro)
        val btnPrau: Button = rootView.findViewById(R.id.btn_Prau)

        // Set listener untuk setiap button, memanggil fungsi navigateToPembayaran dengan parameter yang sesuai
        btnMerapi.setOnClickListener {
            navigateToPembayaran("Gunung Merapi", "Rp. 200.000")
        }
        btnApiPurba.setOnClickListener {
            navigateToPembayaran("Gunung Api Purba Nglanggeran", "Rp. 125.000")
        }
        btnPrau.setOnClickListener {
            navigateToPembayaran("Gunung Prau", "Rp. 225.000")
        }
        btnSindoro.setOnClickListener{
            navigateToPembayaran("Gunung Sindoro", "Rp. 175.000")
        }

        // Mengembalikan tampilan root (view) yang telah dibuat
        return rootView
    }

    // Fungsi untuk berpindah ke halaman PembayaranActivity dengan membawa data namaGunung dan harga sebagai extra
    private fun navigateToPembayaran(namaGunung: String, harga: String) {
        val intent = Intent(requireContext(), PembayaranActivity::class.java)
        intent.putExtra(DATA_NAMA, namaGunung)
        intent.putExtra(DATA_HARGA, harga)
        startActivity(intent)
    }
}
