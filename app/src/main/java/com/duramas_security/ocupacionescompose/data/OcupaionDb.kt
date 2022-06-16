package com.duramas_security.ocupacionescompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.duramas_security.ocupacionescompose.models.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version = 1,
    exportSchema = false
)
abstract class OcupaionDb: RoomDatabase() {
    abstract fun ocupacionDao(): OcupacionDao
}