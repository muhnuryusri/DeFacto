package com.application.defacto.menu.law.fragment.keputusan_presiden

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
import com.application.defacto.databinding.FragmentKeputusanPresidenBinding
import com.application.defacto.menu.law.fragment.peraturan_presiden.PeraturanPresidenViewModel
import com.application.defacto.menu.ui.detail.DetailLawActivity
import com.application.defacto.utils.ViewModelFactory

class KeputusanPresidenFragment : Fragment(), DataCallback {
    private lateinit var adapter: LawAdapter
    private lateinit var keputusanPresidenViewModel: KeputusanPresidenViewModel
    private lateinit var keputusanPresidenBinding: FragmentKeputusanPresidenBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        keputusanPresidenBinding = FragmentKeputusanPresidenBinding.inflate(layoutInflater)
        return keputusanPresidenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        keputusanPresidenViewModel = ViewModelProvider(this, factory)[KeputusanPresidenViewModel::class.java]
        keputusanPresidenViewModel.getKeputusanPresidenList().observe(viewLifecycleOwner, { listLaw ->
            keputusanPresidenBinding.rvList.adapter?.let { adapter ->
                when (adapter) {
                    is LawAdapter -> adapter.setData(listLaw)
                }
            }
        })
        showRecyclerList()
    }

    private fun showRecyclerList() {
        adapter = LawAdapter(this@KeputusanPresidenFragment)

        keputusanPresidenBinding.rvList.layoutManager = LinearLayoutManager(activity)
        keputusanPresidenBinding.rvList.adapter = adapter
    }

    override fun onItemClicked(data: LawEntity) {
        val intent = Intent(context, DetailLawActivity::class.java)
        intent.putExtra(DetailLawActivity.EXTRA_DATA, data.id)
        intent.putExtra(DetailLawActivity.EXTRA_CATEGORY, DataHelper.KEPUTUSAN_PRESIDEN)
        context?.startActivity(intent)
    }
}