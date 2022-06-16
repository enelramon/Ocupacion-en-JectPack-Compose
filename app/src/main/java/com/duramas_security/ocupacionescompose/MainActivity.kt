package com.duramas_security.ocupacionescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.duramas_security.ocupacionescompose.ui.ocupacion.GuardarOcupacion
import com.duramas_security.ocupacionescompose.ui.ocupacion.ListaOcupacion
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = "guardarocupacion"
            ) {
                composable("guardarocupacion") {
                    GuardarOcupacion(navController)
                }
                composable("lista") {
                    ListaOcupacion()
                }
            }
        }
    }
}

