package com.hamza.characterapp.di

import com.hamza.characterapp.data.retrofit.ApiCalls
import com.hamza.characterapp.data.retrofit.RetrofitConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"


    @Provides
    @Singleton
    fun provideRetrofit(): ApiCalls = RetrofitConnection.getRetrofit(BASE_URL)

}