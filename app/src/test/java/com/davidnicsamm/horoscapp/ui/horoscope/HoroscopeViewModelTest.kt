package com.davidnicsamm.horoscapp.ui.horoscope

import com.davidnicsamm.horoscapp.data.providers.HoroscopeProvider
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo
import com.davidnicsamm.horoscapp.motherobject.HoroscopeMotherObject.horoscopeInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    @MockK() // Crea objetos "falsos" de una clase
    lateinit var horoscopeProvider: HoroscopeProvider

    @Before // Se ejecuta antes de un test

    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewmodel is created then horoscopes ar loaded`(){

        every{ horoscopeProvider.getHoroscopes() } returns horoscopeInfoList
        val viewModel = HoroscopeViewModel(horoscopeProvider)

        val horocoscopes: List<HoroscopeInfo> = viewModel.horoscope.value

        assertTrue(horocoscopes.isNotEmpty())
    }


}