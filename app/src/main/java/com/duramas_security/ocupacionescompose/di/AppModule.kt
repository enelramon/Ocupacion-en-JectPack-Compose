package com.duramas_security.ocupacionescompose.di

import android.content.Context
import androidx.room.Room
import com.duramas_security.ocupacionescompose.data.OcupacionDao
import com.duramas_security.ocupacionescompose.data.OcupaionDb
import com.duramas_security.ocupacionescompose.data.RepositoryOcupacion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun ProvideOcupacionDb(@ApplicationContext context: Context): OcupaionDb {
        val DATABASE_NAME = "OcupaionDb"
        return Room.databaseBuilder(
            context,
            OcupaionDb::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvideOcupacionDAO(prestamosDb: OcupaionDb): OcupacionDao
        = prestamosDb.ocupacionDao()

    @Provides
    fun ProvideRepositoryOcupacion(ocupacionDao: OcupacionDao) : RepositoryOcupacion
        = RepositoryOcupacion(ocupacionDao)
}