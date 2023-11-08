package com.davidnicsamm.horoscapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.davidnicsamm.horoscapp.R
import com.davidnicsamm.horoscapp.databinding.ActivityHorscopeDetailBinding
import com.davidnicsamm.horoscapp.domain.model.HoroscopeModel
import com.davidnicsamm.horoscapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HorscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorscopeDetailBinding
    private val horoscopeDetailVewModel: HoroscopeDetailVewModel by viewModels()

    private val args:HorscopeDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHorscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailVewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener{ onBackPressed()}
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailVewModel.state.collect{
                    when(it){
                        is HoroscopeDetailState.Error -> erorrState()

                        HoroscopeDetailState.Loading ->loadingState()

                        is HoroscopeDetailState.Success -> successState(it)

                    }
                }
            }
        }
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when(state.horoscopeModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun erorrState() {
        binding.pb.isVisible = false
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }
}