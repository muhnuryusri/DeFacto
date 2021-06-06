package com.application.defacto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.application.defacto.databinding.ActivityMainBinding
import com.application.defacto.menu.*
import com.application.defacto.menu.ui.LawActivity
import com.application.defacto.menu.artikel.ArticleFragment
import com.application.defacto.menu.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
    private lateinit var articleFragment: ArticleFragment
    private lateinit var forumFragment: ForumFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.bottomNav.menu.getItem(2).isEnabled = false

        mainBinding.fab.setOnClickListener {
            val intent = Intent(this, LawActivity::class.java)
            startActivity(intent)
        }

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        mainBinding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.article -> {
                    articleFragment = ArticleFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, articleFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.forum -> {
                    forumFragment = ForumFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, forumFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, profileFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            true
        }
    }
}