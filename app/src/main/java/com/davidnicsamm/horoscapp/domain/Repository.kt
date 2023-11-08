package com.davidnicsamm.horoscapp.domain

import com.davidnicsamm.horoscapp.data.network.response.PredictionResponse
import com.davidnicsamm.horoscapp.domain.model.PredictionModel

// Interface que actúa como controller
interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}