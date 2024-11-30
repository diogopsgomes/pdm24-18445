package com.example.articles.domain.model

import com.example.articles.data.remote.model.MultimediaDto

data class Result (
    val abstract: String,
    val created_date: String,
    val multimedia: List<MultimediaDto>,
    val published_date: String,
    val section: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
)