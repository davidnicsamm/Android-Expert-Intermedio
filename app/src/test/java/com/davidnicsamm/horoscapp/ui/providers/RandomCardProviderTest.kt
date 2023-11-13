package com.davidnicsamm.horoscapp.ui.providers

import com.davidnicsamm.horoscapp.ui.model.LuckyModel
import org.junit.Assert.*
import org.junit.Test

class RandomCardProviderTest {

    @Test
    fun `getRandomCard should return a random card`() {
        //Given
        val randomCard = RandomCardProvider()

        //When
        val card: LuckyModel? = randomCard.getLucky()


        //Then
        assertNotNull(card)


    }
}