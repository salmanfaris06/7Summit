package com.example.a7summit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7summit.Adapter.ViewPagerAdapter
import com.example.a7summit.Fragment.HomeFragment
import com.example.a7summit.Fragment.UserFragment
import com.example.a7summit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding untuk Activity
    lateinit var binding: ActivityMainBinding

    // Fungsi yang dipanggil saat Activity dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate layout untuk Activity ini menggunakan binding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur tab
        setupTab()
    }

    // Fungsi untuk mengatur tab menggunakan TabLayout dan ViewPager
    private fun setupTab() {
        // Membuat adapter untuk ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home") // Menambahkan fragment HomeFragment ke adapter
        adapter.addFragment(UserFragment(), "Profile") // Menambahkan fragment UserFragment ke adapter

        // Mengatur adapter pada ViewPager dan menghubungkannya dengan TabLayout
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        // Menambahkan ikon pada tab
        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_person)
    }
}
