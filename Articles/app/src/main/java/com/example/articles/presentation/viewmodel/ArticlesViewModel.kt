package com.example.articles.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articles.data.remote.api.RetrofitInstance
import com.example.articles.data.repository.ArticleRepositoryImpl
import com.example.articles.domain.model.Result
import com.example.articles.domain.use_case.GetArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    private val repository = ArticleRepositoryImpl(api)
    private val getArticlesUseCase = GetArticlesUseCase(repository)

    val articles = MutableStateFlow<List<Result>>(emptyList())
    val isLoading = MutableStateFlow(false)

    fun fetchArticles() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                articles.value = getArticlesUseCase()
            } catch (e: Exception) {
                articles.value = emptyList()
            } finally {
                isLoading.value = false
            }
        }
    }
}