package com.duramas_security.ocupacionescompose.data

import com.duramas_security.ocupacionescompose.models.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryOcupacion @Inject constructor(
    val ocupacionDao: OcupacionDao
) {
    fun GetLista(): Flow<List<Ocupacion>> = ocupacionDao.GetLista()
    suspend fun Insertar(ocupacion: Ocupacion)= ocupacionDao.Insertar(ocupacion)
    suspend fun Eliminar(ocupacion: Ocupacion)= ocupacionDao.Eliminar(ocupacion)
}