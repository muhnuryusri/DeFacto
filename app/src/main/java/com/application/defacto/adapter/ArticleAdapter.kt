package com.application.defacto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.defacto.data.local.entity.ArticleEntity
import com.application.defacto.databinding.ItemListArticleBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private val listItems = ArrayList<ArticleEntity>()

    fun setData(data: List<ArticleEntity>) {
        listItems.clear()
        listItems.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListArticleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    inner class ViewHolder(private val binding: ItemListArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ArticleEntity) {
            with(binding) {
                tvJudul.text = data.judul
                tvPengarang.text = data.pengarang
            }
        }
    }
}