package com.example.articles.data.remote.model

import com.example.articles.domain.model.Doc

data class DocDto (
    val abstract: String,
    val lead_paragraph: String,
    val multimedia: List<MultimediaDetailDto>,
    val pub_date: String,
    val section_name: String,
    val snippet: String,
    val subsection_name: String,
    val uri: String,
) {
    fun toArticle(): Doc {
        return Doc (
            abstract = abstract,
            lead_paragraph = lead_paragraph,
            multimedia = multimedia,
            pub_date = pub_date,
            section_name = section_name,
            snippet = snippet,
            subsection_name = subsection_name,
            uri = uri,
        )
    }
}