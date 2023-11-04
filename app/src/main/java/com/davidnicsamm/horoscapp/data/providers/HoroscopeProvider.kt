package com.davidnicsamm.horoscapp.data.providers

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
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries, Taurus, Gemini,
            Cancer, Leo, Virgo,
            Libra, Scorpio, Sagittarius,
            Capricorn, Aquarius, Pisces
        )
    }
}