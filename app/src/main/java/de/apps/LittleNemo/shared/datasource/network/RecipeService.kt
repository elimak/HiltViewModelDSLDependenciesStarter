package de.apps.LittleNemo.shared.datasource.network

import de.apps.LittleNemo.domain.model.Recipe

interface RecipeService {

    suspend fun search(
        page: Int,
        query: String,
    ): List<Recipe>

    suspend fun get(
        id: Int
    ): Recipe
}