package com.application.defacto.menu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.defacto.adapter.SectionsPagerAdapter
import com.application.defacto.databinding.ActivityLawBinding

class LawActivity : AppCompatActivity() {
    private lateinit var lawBinding: ActivityLawBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lawBinding = ActivityLawBinding.inflate(layoutInflater)
        setContentView(lawBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        lawBinding.viewPager.adapter = sectionsPagerAdapter
        lawBinding.tabs.setupWithViewPager(lawBinding.viewPager)
    }
}