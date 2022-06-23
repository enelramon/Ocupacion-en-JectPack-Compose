package com.duramas_security.ocupacionescompose.componen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duramas_security.ocupacionescompose.ui.theme.Azul200
import com.duramas_security.ocupacionescompose.ui.theme.White000

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BarraTitulo(titulo:String) {
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
            IconButton(onClick = { /*TODO*/ }) {
                BadgeBox(
                    badgeContent ={ Text(text = "5") },
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


