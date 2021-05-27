package id.arsha.core.domain.repository

import id.arsha.core.data.Resource
import id.arsha.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface IMealRepository {

    fun getAllMeal(): Flow<Resource<List<Meal>>>

    fun getFavoriteMeal(): Flow<List<Meal>>

    fun setFavoriteMeal(meal: Meal, state: Boolean)

}