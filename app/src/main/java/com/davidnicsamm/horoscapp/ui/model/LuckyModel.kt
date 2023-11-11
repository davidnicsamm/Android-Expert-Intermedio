package com.davidnicsamm.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel (
    // Obliga que image contenga una referencia a drawable o string
    @DrawableRes val image: Int,
    @StringRes val text: Int
)