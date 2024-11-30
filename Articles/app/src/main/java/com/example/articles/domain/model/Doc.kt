package com.example.articles.domain.model

import com.example.articles.data.remote.model.MultimediaDetailDto

data class Doc (
    val abstract: String,
    val lead_paragraph: String,
    val multimedia: List<MultimediaDetailDto>,
    val pub_date: String,
    val section_name: String,
    val snippet: String,
    val subsection_name: String,
    val uri: String,
)