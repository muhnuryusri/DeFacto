package com.application.defacto.menu.law.fragment.peraturan_presiden

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.defacto.adapter.LawAdapter
import com.application.defacto.data.DataCallback
import com.application.defacto.data.DataHelper
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.databinding.FragmentPeraturanPresidenBinding
import com.application.defacto.menu.law.fragment.undang_undang.UndangUndangViewModel
import com.application.defacto.menu.ui.detail.DetailLawActivity
import com.application.defacto.utils.ViewModelFactory

class PeraturanPresidenFragment : Fragment(), DataCallback {
    private lateinit var adapter: LawAdapter
    private lateinit var peraturanPresidenViewModel: PeraturanPresidenViewModel
    private lateinit var peraturanPresidenBinding: FragmentPeraturanPresidenBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        peraturanPresidenBinding = FragmentPeraturanPresidenBinding.inflate(layoutInflater)
        return peraturanPresidenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        peraturanPresidenViewModel = ViewModelProvider(this, factory)[PeraturanPresidenViewModel::class.java]
        peraturanPresidenViewModel.getPeraturanPresidenList().observe(viewLifecycleOwner, { listLaw ->
            peraturanPresidenBinding.rvList.adapter?.let { adapter ->
                when (adapter) {
                    is LawAdapter -> adapter.setData(listLaw)
                }
            }
        })
        showRecyclerList()
    }

    private fun showRecyclerList() {
        adapter = LawAdapter(this@PeraturanPresidenFragment)

        peraturanPresidenBinding.rvList.layoutManager = LinearLayoutManager(activity)
        peraturanPresidenBinding.rvList.adapter = adapter
    }

    override fun onItemClicked(data: LawEntity) {
        val intent = Intent(context, DetailLawActivity::class.java)
        intent.putExtra(DetailLawActivity.EXTRA_DATA, data.id)
        intent.putExtra(DetailLawActivity.EXTRA_CATEGORY, DataHelper.PERATURAN_PRESIDEN)
        context?.startActivity(intent)
    }
}