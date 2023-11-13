package com.davidnicsamm.horoscapp.motherobject

import com.davidnicsamm.horoscapp.data.network.response.PredictionResponse
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.Aries, HoroscopeInfo.Taurus, HoroscopeInfo.Gemini,
        HoroscopeInfo.Cancer, HoroscopeInfo.Leo, HoroscopeInfo.Virgo,
        HoroscopeInfo.Libra, HoroscopeInfo.Scorpio, HoroscopeInfo.Sagittarius,
        HoroscopeInfo.Capricorn, HoroscopeInfo.Aquarius, HoroscopeInfo.Pisces
    )
}