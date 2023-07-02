package com.example.sequel.di

import android.content.Context
import androidx.room.Room
import com.example.sequel.data.db.MainDatabase
import com.example.sequel.network.BASE_URL
import com.example.sequel.network.DataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MainDatabase {
        return Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            "main_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(db: MainDatabase) = db.getDao()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): DataService = retrofit.create(DataService::class.java)
}