package com.duramas_security.ocupacionescompose.ui.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.duramas_security.ocupacionescompose.componen.BarraTitulo
import com.duramas_security.ocupacionescompose.componen.SnackBar
import com.duramas_security.ocupacionescompose.ui.theme.Azul200
import com.duramas_security.ocupacionescompose.ui.theme.Shapes
import com.duramas_security.ocupacionescompose.ui.theme.White000

@Composable
fun GuardarOcupacion(
    navController: NavHostController,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val descripcion = remember { mutableStateOf("") }
    val salario  = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BarraTitulo("Ocupacion")
        OutlinedTextField(
            value = descripcion.value,
            onValueChange = { descripcion.value = it },
            label = { Text(text = "Ocupacion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = salario.value,
            onValueChange = { salario.value = it },
            label = {
                Text(text = "Salario")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        var klk = true
        Button(
            onClick = {
                klk = guardarOcupacion(viewModel,descripcion.value,salario.value)
                if(guardarOcupacion(viewModel,descripcion.value,salario.value)){
                   descripcion.value = ""
                   salario.value = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(backgroundColor = Azul200)
        ) {
            Text(
                fontSize = 16.sp,
                text = "Guardar",
                color = White000
            )
        }
        if (klk == false)
            SnackBar(informacion = "hola")

        Button(
            onClick = { navController.navigate("lista") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(backgroundColor = Azul200)
        ) {

            Text(
                fontSize = 16.sp,
                text = "Ver Lista",
                color = White000
            )
        }
    }
}


fun guardarOcupacion(viewModel: MainActivityViewModel ,descripcion:String,salario:String):Boolean{
    if (descripcion.length == 0)
        return false
    
    if (salario.length == 0)
        return false
    
    viewModel.insertarOcupacion(
        descripcion,
        salario.toDouble()
    )
    return true
}

