package com.example.coins.domain.repository

import com.example.coins.domain.model.Coin
import com.example.coins.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinDetail(coinId: String): CoinDetail
}