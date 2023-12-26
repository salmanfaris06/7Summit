package com.example.a7summit.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT

// Mendefinisikan kelas ViewPagerAdapter yang mengambil FragmentManager sebagai parameter konstruktor
class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // Daftar Fragment yang akan ditampilkan
    private val FragmentList = ArrayList<Fragment>()

    // Daftar judul untuk setiap Fragment
    private val FragmentTitleList = ArrayList<String>()

    // Override fungsi getCount() untuk mengembalikan jumlah Fragment dalam daftar
    override fun getCount(): Int {
        return FragmentList.size
    }

    // Override fungsi getItem() untuk mendapatkan Fragment pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return FragmentList[position]
    }

    // Override fungsi getPageTitle() untuk mendapatkan judul Fragment pada posisi tertentu
    override fun getPageTitle(position: Int): CharSequence? {
        return FragmentTitleList[position]
    }

    // Fungsi untuk menambahkan Fragment ke daftar
    fun addFragment(fragment: Fragment, title: String) {
        FragmentList.add(fragment)
        FragmentTitleList.add(title)
    }
}