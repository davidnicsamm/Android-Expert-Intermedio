package com.davidnicsamm.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.davidnicsamm.horoscapp.databinding.ItemHoroscopeBinding
import com.davidnicsamm.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.setText(horoscopeInfo.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLamda = {onItemSelected(horoscopeInfo)})

            //onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnimation(view: View, newLamda:()->Unit){
        view.animate().apply{
            duration = 500
            interpolator = LinearInterpolator() // La animación es siempre a la misma velocidad.
            rotationBy(360f)
            withEndAction{ newLamda()}
            start()
        }
    }
}