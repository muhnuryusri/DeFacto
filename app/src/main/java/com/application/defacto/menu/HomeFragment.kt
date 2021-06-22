package com.application.defacto.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.application.defacto.R
import com.application.defacto.databinding.FragmentHomeBinding
import com.application.defacto.menu.artikel.ArticleFragment
import com.application.defacto.menu.law.fragment.keputusan_presiden.KeputusanPresidenFragment
import com.application.defacto.menu.law.fragment.peraturan_pemerintah.PeraturanPemerintahFragment
import com.application.defacto.menu.law.fragment.peraturan_presiden.PeraturanPresidenFragment
import com.application.defacto.menu.law.fragment.undang_undang.UndangUndangFragment
import com.application.defacto.menu.law.fragment.undang_undang.UndangUndangViewModel
import com.application.defacto.menu.profile.ProfileFragment

class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var undangUndangFragment: UndangUndangFragment
    private lateinit var peraturanPemerintahFragment: PeraturanPemerintahFragment
    private lateinit var peraturanPresidenFragment: PeraturanPresidenFragment
    private lateinit var keputusanPresidenFragment: KeputusanPresidenFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.undangUndang.setOnClickListener {
            undangUndangFragment = UndangUndangFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.container, undangUndangFragment)
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }

        homeBinding.peraturanPemerintah.setOnClickListener {
            peraturanPemerintahFragment = PeraturanPemerintahFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.container, peraturanPemerintahFragment)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        homeBinding.peraturanPresiden.setOnClickListener {
            peraturanPresidenFragment = PeraturanPresidenFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.container, peraturanPresidenFragment)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        homeBinding.keputusanPresiden.setOnClickListener {
            keputusanPresidenFragment = KeputusanPresidenFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.container, keputusanPresidenFragment)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }
    }
}