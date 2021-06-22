package com.application.defacto.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.defacto.data.DataCallback
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.databinding.ItemListLawBinding

class LawAdapter(private val callback: DataCallback) : RecyclerView.Adapter<LawAdapter.ViewHolder>() {
    private val listItems = ArrayList<LawEntity>()

    fun setData(data: List<LawEntity>) {
        listItems.clear()
        listItems.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListLawBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    inner class ViewHolder(private val binding: ItemListLawBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: LawEntity) {
            with(binding) {
                tvNomor.text = "No." + data.nomor
                tvJudul.text = data.judul
                tvStatus.text = data.status
                tvTanggal.text = data.tanggal_penetapan
            }

            binding.item.setOnClickListener {
                callback.onItemClicked(data)
            }
        }
    }
}