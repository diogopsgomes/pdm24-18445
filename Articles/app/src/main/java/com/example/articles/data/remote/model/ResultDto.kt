package com.example.articles.data.remote.model

import com.example.articles.domain.model.Result

data class ResultDto (
    val abstract: String,
    val created_date: String,
    val multimedia: List<MultimediaDto>,
    val published_date: String,
    val section: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
) {
    fun toArticles(): Result {
        return Result (
            abstract = abstract,
            created_date = created_date,
            multimedia = multimedia,
            published_date = published_date,
            section = section,
            subsection = subsection,
            title = title,
            updated_date = updated_date,
            uri = uri,
        )
    }
}