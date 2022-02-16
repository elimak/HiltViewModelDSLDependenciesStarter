package de.apps.LittleNemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.apps.LittleNemo.shared.datasource.network.KtorClientFactory
import de.apps.LittleNemo.shared.datasource.network.RecipeService
import de.apps.LittleNemo.shared.datasource.network.RecipeServiceImpl
import io.ktor.client.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
/*
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,
    ): RecipeService {
        return RecipeServiceImpl(
            httpClient = httpClient,
            baseUrl = RecipeServiceImpl.BASE_URL,
        )
    }
    */

}