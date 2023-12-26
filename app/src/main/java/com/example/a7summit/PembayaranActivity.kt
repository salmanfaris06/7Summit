package com.example.a7summit

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.a7summit.databinding.ActivityPembayaranBinding
import java.util.Calendar

class PembayaranActivity : AppCompatActivity() {

    // Binding untuk Activity
    private lateinit var binding: ActivityPembayaranBinding

    // Calendar untuk mengelola tanggal
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate layout untuk Activity ini menggunakan binding
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari Intent
        val namaGunung = intent.getStringExtra(DATA_NAMA)
        val hargaTiket = intent.getStringExtra(DATA_HARGA)

        // Menampilkan data pada TextView
        binding.inDestination.text = namaGunung
        binding.inPrice.text = hargaTiket

        // Menambahkan OnClickListener pada button pembayaran
        binding.btnConfPay.setOnClickListener {
            showCustomDialog()
        }

        // Menambahkan OnClickListener pada EditText tanggal
        binding.inDate.setOnClickListener {
            showDatePicker()
        }
    }

    // Fungsi untuk menampilkan date picker dialog
    private fun showDatePicker() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Membuat date picker dialog
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // Handle selected date
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.inDate.text = selectedDate
            },
            year,
            month,
            day
        )

        // Tampilkan date picker dialog
        datePickerDialog.show()
    }

    // Fungsi untuk menampilkan dialog konfirmasi
    private fun showCustomDialog() {
        val builder = AlertDialog.Builder(this)

        // Inflate layout dialog konfirmasi
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.confirm_dialog, null)
        builder.setView(dialogView)

        // Mendapatkan reference button dari layout dialog
        val btnConfirm: Button = dialogView.findViewById(R.id.btn_confirm)

        // Menambahkan OnClickListener pada button konfirmasi
        btnConfirm.setOnClickListener {
            openMap()
        }

        // Membuat dan menampilkan dialog
        val alertDialog = builder.create()
        alertDialog.show()
    }

    // Fungsi untuk membuka aplikasi maps
    private fun openMap() {
        val latitude = -7.540561476419376
        val longitude = 110.44570410768596

        // Buat Uri untuk membuka maps
        val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude")

        // Intent untuk membuka aplikasi maps
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        // Cek apakah aplikasi maps terpasang atau tidak
        if (mapIntent.resolveActivity(this.packageManager) != null) {
            startActivity(mapIntent)
        } else {
            // Tampilkan pesan jika aplikasi maps tidak terpasang
            Toast.makeText(this, "Aplikasi maps tidak terpasang", Toast.LENGTH_SHORT).show()
        }
    }

    // Companion object untuk menyimpan data yang akan dikirimkan melalui Intent
    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_HARGA = "data_harga"
    }
}
