package com.application.defacto.menu.artikel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.defacto.adapter.ArticleAdapter
import com.application.defacto.data.local.entity.ArticleEntity
import com.application.defacto.databinding.FragmentArticleBinding

class ArticleFragment : Fragment() {
    private lateinit var adapter: ArticleAdapter
    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var articleBinding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        articleBinding = FragmentArticleBinding.inflate(layoutInflater)
        return articleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ArticleViewModel::class.java]
        val article = articleViewModel.getArticleList()
        showRecyclerList(article)
    }

    private fun showRecyclerList(items: List<ArticleEntity>) {
        adapter = ArticleAdapter()
        adapter.setData(items)

        articleBinding.rvArticle.layoutManager = LinearLayoutManager(activity)
        articleBinding.rvArticle.adapter = adapter
    }
}