package com.example.coins.data.repository

import com.example.coins.data.remote.api.CoinPaprikaApi
import com.example.coins.domain.model.Coin
import com.example.coins.domain.model.CoinDetail
import com.example.coins.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail {
        return api.getCoinDetail(coinId).toCoinDetail()
    }
}