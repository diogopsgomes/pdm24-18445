package com.example.articles.domain.use_case

import com.example.articles.domain.model.Doc
import com.example.articles.domain.repository.ArticleRepository

class GetArticleUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(articleUri: String): Doc {
        return repository.getArticle(articleUri)
    }
}