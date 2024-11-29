package com.example.coins.domain.use_case

import com.example.coins.domain.model.CoinDetail
import com.example.coins.domain.repository.CoinRepository

class GetCoinDetailUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(coinId: String): CoinDetail {
        return repository.getCoinDetail(coinId)
    }
}