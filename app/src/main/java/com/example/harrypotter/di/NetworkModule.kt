package com.example.harrypotter.di

import com.example.harrypotter.api.CharacterAPI
import com.example.harrypotter.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesCharacterAPI():CharacterAPI {
        return providesRetrofit()
            .create(CharacterAPI::class.java)
    }
}