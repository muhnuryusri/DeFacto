package com.application.defacto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.defacto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.bottomNav.menu.getItem(2).isEnabled = false
    }
}