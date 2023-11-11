package com.davidnicsamm.horoscapp.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import com.davidnicsamm.horoscapp.Manifest
import com.davidnicsamm.horoscapp.R
import com.davidnicsamm.horoscapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint


// Para recibir elementos injectados
@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    companion object{
        private const val CAMERA_PERMISSION = android.Manifest.permission.CAMERA
    }

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // startCamera()
        } else {
            // Si no tiene los permisos aceptados, y los rechaza.
            Toast.makeText(
                requireContext(),
                "Debe aceptar loss permisos para usar la cámara",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Permiso para la cámara
        super.onViewCreated(view, savedInstanceState)

        if (checkCameraPermission()) {
            // Tiene permisos aceptados
            // startCamera()
        } else {
            // Debe pedir parmisos
            requestPermissionLauncher.launch(CAMERA_PERMISSION)

        }
    }

    // Verificar si ya tiene el permiso aceptado
    fun checkCameraPermission(): Boolean {
        return PermissionChecker.checkSelfPermission(
            requireContext(),
            CAMERA_PERMISSION
        ) == PermissionChecker.PERMISSION_GRANTED
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}