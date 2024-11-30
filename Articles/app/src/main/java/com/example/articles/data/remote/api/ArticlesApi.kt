package com.example.articles.data.remote.api

import com.example.articles.data.remote.model.ArticleDto
import com.example.articles.data.remote.model.ArticlesDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitInstance {
    val api: ArticlesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticlesApi::class.java)
    }
}

interface ArticlesApi {
    @GET("topstories/v2/home.json?api-key=ZZZIqkKX3rUQyw4p17Aa8b8NyQB8IHM6")
    suspend fun getArticles(): ArticlesDto

    @GET("search/v2/articlesearch.json?&api-key=ZZZIqkKX3rUQyw4p17Aa8b8NyQB8IHM6")
    suspend fun getArticle(@Query("fq") fq: String): ArticleDto
}