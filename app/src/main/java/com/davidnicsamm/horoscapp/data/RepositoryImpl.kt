package com.davidnicsamm.horoscapp.data

import android.util.Log
import com.davidnicsamm.horoscapp.data.network.HoroscopeApiService
import com.davidnicsamm.horoscapp.domain.Repository
import com.davidnicsamm.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {

        // Realizar petición retrofit
        kotlin.runCatching {
            apiService.getHoroscope(sign)
        }
            .onSuccess {
                // Se ejecuta si hubo una respuesta satisfactoria de la api
                return it.toDomain()
            }
            .onFailure {
                // Si no hubo una respuesta satisfactoria de la api
                Log.i("david", "Ha ocurrido un error en la respuesta: ${it.message}")
            }
        return null
    }
}