package com.example.a7summit.Fragment

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.a7summit.R
import com.example.a7summit.databinding.FragmentHomeBinding
import com.example.a7summit.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        val btnMerapi: Button = rootView.findViewById(R.id.btn_merapi)
        val btnApiPurba: Button = rootView.findViewById(R.id.btn_apiPurba)
        val btnSindoro: Button = rootView.findViewById(R.id.btn_Sindoro)
        val btnPrau: Button = rootView.findViewById(R.id.btn_Prau)
        btnMerapi.setOnClickListener {
            //Ga bisa caranya
            showCustomDialog()
        }
        btnApiPurba.setOnClickListener {
            // Belum diganti
            showCustomDialog()
        }
        btnPrau.setOnClickListener {
            //Belum diganti
            showCustomDialog()
        }
        btnSindoro.setOnClickListener {
            //Belum diganti
            showCustomDialog()
        }
        return rootView
    }

    private fun showCustomDialog() {

        val builder = AlertDialog.Builder(requireContext())

        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.confirm_dialog, null)
        builder.setView(dialogView)

        val btnConfirm: Button = dialogView.findViewById(R.id.btn_confirm)

        btnConfirm.setOnClickListener {
            openMap()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
    private fun openMap() {
        val latitude = -7.540561476419376
        val longitude = 110.44570410768596

        // Buat Uri untuk membuka maps
        val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")

        // Intent untuk membuka aplikasi maps
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(requireContext(), "Aplikasi maps tidak terpasang", Toast.LENGTH_SHORT).show()
        }
    }
}