package com.application.defacto.menu.artikel

import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.ArticleEntity
import com.application.defacto.utils.DataDummy

class ArticleViewModel: ViewModel() {
    fun getArticleList(): List<ArticleEntity> = DataDummy.getDummyArticle()
}