package com.davidnicsamm.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidnicsamm.horoscapp.domain.model.HoroscopeModel
import com.davidnicsamm.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HoroscopeDetailVewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope:HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // Se ejecuta en el hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result =
                withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) } // Se ejecuta en el hilo secundario

            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscope)
            } else {
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error, inténtelo mas tarde.")
            }


            // Se ejecuta en el hilo principal
        }
    }

}