package com.example.articles.domain.repository

import com.example.articles.domain.model.Doc
import com.example.articles.domain.model.Result

interface ArticleRepository {
    suspend fun getArticles(): List<Result>
    suspend fun getArticle(articleUri: String): Doc
}