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
        var namaGunung: String = ""
        var harga: String = ""
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val btnMerapi: Button = rootView.findViewById(R.id.btn_merapi)
        val btnApiPurba: Button = rootView.findViewById(R.id.btn_apiPurba)
        val btnSindoro: Button = rootView.findViewById(R.id.btn_Sindoro)
        val btnPrau: Button = rootView.findViewById(R.id.btn_Prau)
        val intent = Intent(requireContext(), PembayaranActivity::class.java)

        btnMerapi.setOnClickListener {
            namaGunung = "Gunung Merapi"
            harga = "Rp. 200.000"
            startActivity(intent)
            intent.putExtra(DATA_NAMA,namaGunung)
            intent.putExtra(DATA_HARGA,harga)
        }
        btnApiPurba.setOnClickListener {
            namaGunung = "Gunung Api Purba"
            harga = "Rp. 125.000"
            startActivity(intent)
            intent.putExtra(DATA_NAMA,namaGunung)
            intent.putExtra(DATA_HARGA,harga)
        }
        btnPrau.setOnClickListener {
            namaGunung = "Gunung Prau"
            harga = "Rp. 225.000"
            startActivity(intent)
            intent.putExtra(DATA_NAMA,namaGunung)
            intent.putExtra(DATA_HARGA,harga)
        }
        btnSindoro.setOnClickListener{
            namaGunung = "Gunung Sindoro"
            harga = "Rp. 175.000"
            startActivity(intent)
            intent.putExtra(DATA_NAMA,namaGunung)
            intent.putExtra(DATA_HARGA,harga)
        }
        return rootView
    }
}