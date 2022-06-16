package com.duramas_security.ocupacionescompose.ui.ocupacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duramas_security.ocupacionescompose.data.RepositoryOcupacion
import com.duramas_security.ocupacionescompose.models.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repositoryOcupacion: RepositoryOcupacion
) :ViewModel() {

    val listaOcupacion : Flow<List<Ocupacion>> = repositoryOcupacion.GetLista()

    fun insertarOcupacion(descripcion : String, salario : Double) {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        val ocupacion =Ocupacion(0,
            descripcion,
            currentDate,
            salario
        )
        viewModelScope.launch(Dispatchers.IO) {
            repositoryOcupacion.Insertar(ocupacion)
        }
    }

    fun Delete(ocupacion: Ocupacion){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryOcupacion.Eliminar(ocupacion)
        }
    }
}