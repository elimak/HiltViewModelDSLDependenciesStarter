package de.apps.LittleNemo.interactors.picture_collection

import de.apps.LittleNemo.domain.data.DataState
import de.apps.LittleNemo.domain.model.Recipe
import de.apps.LittleNemo.shared.datasource.network.RecipeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class SearchPictureCollection(
    private val recipeService: RecipeService,
    //private val recipeCache: RecipeCache,
) {
    fun execute(
       // token: String,
        page: Int,
        query: String,
    ): Flow<DataState<List<Recipe>>> = flow {
        try {
            emit(DataState.loading())

            // just to show pagination, api is fast
//      delay(1000)

    /*
            // force error for testing
            if (query == "error") {
                throw Exception("Search FAILED!")
            }
*/
            //try{

                val recipes = recipeService.search(
                    page = page,
                    query = query,
                )
                emit(DataState.success(recipes))

                //val test = recipes


                // TODO JUST FOR TESTING NOW --> later needs to be from DB
                //---------- PROBLEM ??? ----------------->>>>    NEE WAS KÖNNTE NOCH DAS PROBLEM SEIN ???? emit(DataState.success(recipes))
                /*
                // Convert: NetworkRecipeEntity -> Recipe -> RecipeCacheEntity
                val recipes = getRecipesFromNetwork(
                  //  token = token,
                    page = page,
                    query = query,
                )*/

                // insert into cache
                //recipeDao.insertRecipes(entityMapper.toEntityList(recipes))
          /*  }catch (e: Exception){
                // There was a network issue
                e.printStackTrace()
            }*/

            /*
            // query the cache
            val cacheResult = if (query.isBlank()) {
                recipeDao.getAllRecipes(
                    pageSize = RECIPE_PAGINATION_PAGE_SIZE,
                    page = page
                )
            } else {
                recipeDao.searchRecipes(
                    query = query,
                    pageSize = RECIPE_PAGINATION_PAGE_SIZE,
                    page = page
                )
            }

            // emit List<Recipe> from cache
            val list = entityMapper.fromEntityList(cacheResult)
*/
            //emit(DataState.success(recipes))


        } catch (e: Exception) {
            //emit(DataState.error<List<Recipe>>(e.message ?: "Unknown Error"))
        }
    }

}




/*
    fun execute(
        page: Int,
        query: String,
    ): CommonFlow<DataState<List<Recipe>>> = flow  {
        try{
            //emit(DataState.loading())

            // just to show pagination, api is fast
            delay(500)

            // force error for testing
            if (query == "error") {
                throw Exception("Forcing an error... Search FAILED!")
            }

            val recipes = recipeService.search(
                page = page,
                query = query,
            )
            val test = recipes

            // insert into cache
            recipeCache.insert(recipes)

            // query the cache
            val cacheResult = if (query.isBlank()) {
                recipeCache.getAll(page = page)
            } else {
                recipeCache.search(
                    query = query,
                    page = page,
                )
            }


            // emit List<Recipe> from cache
            emit(DataState.data<List<Recipe>>(message = null, data = cacheResult))


        } catch (e: Exception) {

            emit(DataState.error<List<Recipe>>(
                message = GenericMessageInfo.Builder()
                    .id("SearchRecipes.Error")
                    .title("Error")
                    .uiComponentType(UIComponentType.Dialog)
                    .description(e.message?: "Unknown Error")
            ))
        }
    }.asCommonFlow()
*/
