package com.davidnicsamm.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.davidnicsamm.horoscapp.data.providers.HoroscopeProvider
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Aries
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Leo
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Libra
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo.Virgo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) :
    ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope


    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()


    }

}