package com.application.defacto.menu.law.fragment.undang_undang

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
import com.application.defacto.data.DataHelper.UNDANG_UNDANG
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.databinding.FragmentUndangUndangBinding
import com.application.defacto.menu.ui.detail.DetailLawActivity
import com.application.defacto.utils.ViewModelFactory

class UndangUndangFragment : Fragment(), DataCallback {
    private lateinit var adapter: LawAdapter
    private lateinit var undangUndangViewModel: UndangUndangViewModel
    private lateinit var undangUndangBinding: FragmentUndangUndangBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        undangUndangBinding = FragmentUndangUndangBinding.inflate(layoutInflater)
        return undangUndangBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        undangUndangViewModel = ViewModelProvider(this, factory)[UndangUndangViewModel::class.java]
        undangUndangViewModel.getUndangUndangList().observe(viewLifecycleOwner, { listLaw ->
            undangUndangBinding.rvList.adapter?.let { adapter ->
                when (adapter) {
                    is LawAdapter -> adapter.setData(listLaw)
                }
            }
        })
        showRecyclerList()
    }

    private fun showRecyclerList() {
        adapter = LawAdapter(this@UndangUndangFragment)

        undangUndangBinding.rvList.layoutManager = LinearLayoutManager(activity)
        undangUndangBinding.rvList.adapter = adapter
    }

    override fun onItemClicked(data: LawEntity) {
        val intent = Intent(context, DetailLawActivity::class.java)
        intent.putExtra(DetailLawActivity.EXTRA_DATA, data.id)
        intent.putExtra(DetailLawActivity.EXTRA_CATEGORY, UNDANG_UNDANG)
        context?.startActivity(intent)
    }
}