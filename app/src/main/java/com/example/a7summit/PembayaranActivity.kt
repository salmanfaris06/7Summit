package com.example.a7summit

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.a7summit.databinding.ActivityPembayaranBinding

class PembayaranActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPembayaranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val namaGunung = intent.getStringExtra(DATA_NAMA)
        val hargaTiket = intent.getStringExtra(DATA_HARGA)

        binding.inDestination.text = namaGunung
        binding.inPrice.text = hargaTiket

        binding.inDestination
        binding.inPrice

        binding.btnConfPay.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun showCustomDialog() {

        val builder = AlertDialog.Builder(this)

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

        if (mapIntent.resolveActivity(this.packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Aplikasi maps tidak terpasang", Toast.LENGTH_SHORT).show()
        }
    }
    companion object{
        const val DATA_NAMA = "data_nama"
        const val DATA_HARGA = "data_harga"
    }
}