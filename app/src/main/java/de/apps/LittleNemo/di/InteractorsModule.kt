package de.apps.LittleNemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.apps.LittleNemo.interactors.picture_collection.SearchPictureCollection
import de.apps.LittleNemo.shared.datasource.network.RecipeService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchRecipes(
        //recipeService: RecipeService,
        //recipeCache: RecipeCache,
    ): SearchPictureCollection {
        return SearchPictureCollection(
            //---recipeService = recipeService,
            //recipeCache = recipeCache
        )
    }

    /*
    @InternalAPI
    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache,
    ): GetRecipe {
        return GetRecipe(
            recipeCache = recipeCache
        )
    }*/
}