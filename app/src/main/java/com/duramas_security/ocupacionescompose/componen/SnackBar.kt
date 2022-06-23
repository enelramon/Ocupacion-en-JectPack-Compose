package com.duramas_security.ocupacionescompose.componen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SnackBar(informacion: String) {
    Snackbar(
        action = {
            Button(onClick = { /*TODO*/ }) { }
        },
        modifier = Modifier.padding(8.dp)
    ){
        Text(text = informacion)
    }
}