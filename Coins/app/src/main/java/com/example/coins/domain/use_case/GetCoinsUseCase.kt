package com.example.coins.domain.use_case

import com.example.coins.domain.model.Coin
import com.example.coins.domain.repository.CoinRepository

class GetCoinsUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(): List<Coin> {
        return repository.getCoins()
    }
}