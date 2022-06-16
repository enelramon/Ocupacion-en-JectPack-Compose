package com.duramas_security.ocupacionescompose.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ocupaciones")
data class Ocupacion(
    @PrimaryKey(autoGenerate = true)
    val ocupacionId : Int,
    val descripcion : String,
    val fechaRegistro : String,
    val Salario :Double
)
