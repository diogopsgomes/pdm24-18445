package com.example.articles.domain.use_case

import com.example.articles.domain.model.Result
import com.example.articles.domain.repository.ArticleRepository

class GetArticlesUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(): List<Result> {
        return repository.getArticles()
    }
}