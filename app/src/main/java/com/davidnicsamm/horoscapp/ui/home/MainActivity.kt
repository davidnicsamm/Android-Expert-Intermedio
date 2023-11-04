package com.davidnicsamm.horoscapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.davidnicsamm.horoscapp.R
import com.davidnicsamm.horoscapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

 // Para recibir elementos injectados
 @AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var navController: NavController  // Gestionar navegación.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


    }

    private fun initUI() {
        initNavigation()
    }

    private fun initNavigation() {
        val navHost: NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment //as para castear.
        navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}