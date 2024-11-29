package com.example.coins.data.remote.model

import com.example.coins.domain.model.Coin

data class CoinDto (
    val id: String,
    val name: String,
    val symbol: String
) {
    fun toCoin(): Coin {
        return Coin (
            id = id,
            name = name,
            symbol = symbol
        )
    }
}