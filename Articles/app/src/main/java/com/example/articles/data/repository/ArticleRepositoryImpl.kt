package com.example.articles.data.repository

import com.example.articles.data.remote.api.ArticlesApi
import com.example.articles.domain.model.Doc
import com.example.articles.domain.model.Result
import com.example.articles.domain.repository.ArticleRepository

class ArticleRepositoryImpl(private val api: ArticlesApi) : ArticleRepository {
    override suspend fun getArticles(): List<Result> {
        return api.getArticles().results.map { it.toArticles() }
    }

    override suspend fun getArticle(articleUri: String): Doc {
        val fq = "uri:\"$articleUri\""
        return api.getArticle(fq).response.docs[0].toArticle()
    }
}