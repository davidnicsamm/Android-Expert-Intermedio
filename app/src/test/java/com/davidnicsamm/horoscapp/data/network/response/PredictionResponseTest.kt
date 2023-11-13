package com.davidnicsamm.horoscapp.data.network.response


import com.davidnicsamm.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import org.junit.Assert.*
import org.junit.Test
import io.kotlintest.shouldBe


class PredictionResponseTest{

    @Test
    fun `toDomain should return a correct prediction model`(){
        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()


        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}