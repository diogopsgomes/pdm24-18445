package com.example.coins.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins.data.remote.api.RetrofitInstance
import com.example.coins.data.repository.CoinRepositoryImpl
import com.example.coins.domain.model.CoinDetail
import com.example.coins.domain.use_case.GetCoinDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoinDetailViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    private val repository = CoinRepositoryImpl(api)
    private val getCoinDetailUseCase = GetCoinDetailUseCase(repository)

    val coinDetail = MutableStateFlow<CoinDetail?>(null)

    fun fetchCoinDetail(coinId: String) {
        viewModelScope.launch {
            try {
                coinDetail.value = getCoinDetailUseCase(coinId)
            } catch (e: Exception) {
                coinDetail.value = null
            }
        }
    }
}