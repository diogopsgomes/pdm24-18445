package com.example.articles.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articles.data.remote.api.RetrofitInstance
import com.example.articles.data.repository.ArticleRepositoryImpl
import com.example.articles.domain.model.Doc
import com.example.articles.domain.use_case.GetArticleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    private val repository = ArticleRepositoryImpl(api)
    private val getArticleUseCase = GetArticleUseCase(repository)

    val article = MutableStateFlow<Doc?>(null)
    val isLoading = MutableStateFlow(false)

    fun fetchArticle(articleUri: String) {
        viewModelScope.launch {
            isLoading.value = true
            try {
                article.value = getArticleUseCase(articleUri)
            } catch (e: Exception) {
                article.value = null
            } finally {
                isLoading.value = false
            }
        }
    }
}