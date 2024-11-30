package com.example.articles.domain.model

import com.example.articles.data.remote.model.DocDto

data class Response (
    val docs: List<DocDto>,
)