package com.example.coins.data.remote.model

import com.example.coins.domain.model.CoinDetail

data class CoinDetailDto (
    val id: String,
    val name: String,
    val description: String
) {
    fun toCoinDetail(): CoinDetail {
        return CoinDetail (
            id = id,
            name = name,
            description = description
        )
    }
}