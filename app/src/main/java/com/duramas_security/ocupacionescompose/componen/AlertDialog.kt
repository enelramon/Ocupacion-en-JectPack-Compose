package com.duramas_security.ocupacionescompose.componen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.duramas_security.ocupacionescompose.models.Ocupacion
import com.duramas_security.ocupacionescompose.ui.theme.*

sealed class TiposDialog(
    val titulo: String,
    val color: Color,
    val coloTexto: Color
) {
    object Informacion : TiposDialog("Informacion", Azul200, Azul700)
    object Error : TiposDialog("Error", Orange, Color.Red)
}

@Composable
fun AlertDialogprobando(
    tipoDialog: TiposDialog,
    ocupacion: Ocupacion ,
    show: Boolean = false,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit = {},
    textDismiss : String = ""
) {
    if (show) {
        AlertDialog(onDismissRequest = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            confirmButton = {
                TextButton(onClick ={onConfirm()}){
                    Text(text = "Ok", color = tipoDialog.color)
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = textDismiss.toString(), color = tipoDialog.color)
                }
            },
            title = {
                Text(
                    tipoDialog.titulo, modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    color = tipoDialog.color,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            },
            text = {
                Column {
                    Text(
                        ocupacion.descripcion, modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        color = tipoDialog.coloTexto,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        ocupacion.fechaRegistro, modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        color = tipoDialog.coloTexto,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        ocupacion.Salario.toString(), modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        color = tipoDialog.coloTexto,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun hola() {
    AlertDialogprobando(
        TiposDialog.Informacion,
        Ocupacion(
            1,
            "Programador",
            "24/06/2022",
            80000.0
        ),
        true,
        {}
    )
}