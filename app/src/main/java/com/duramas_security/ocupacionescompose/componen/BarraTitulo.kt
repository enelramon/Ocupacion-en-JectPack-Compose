package com.duramas_security.ocupacionescompose.componen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duramas_security.ocupacionescompose.ui.theme.Azul200

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BarraTitulo(titulo:String,_counter : Int = 5) {

    var counter by rememberSaveable { mutableStateOf(_counter)}

    TopAppBar(
        backgroundColor =  Azul200,
        title = {
            Text(
                titulo, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        actions = {
            IconButton(onClick = {counter++ }) {
                BadgeBox(
                    badgeContent ={ Text(counter.toString()) },
                    backgroundColor = Color.White
                ) {
                    Icon(
                        Icons.Outlined.Add,
                        contentDescription = "Agregar",
                        tint = Color.White,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    )
}


