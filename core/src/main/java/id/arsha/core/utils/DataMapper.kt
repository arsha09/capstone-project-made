package id.arsha.core.utils

import id.arsha.core.data.source.local.entity.MealEntity
import id.arsha.core.data.source.remote.response.MealResponse
import id.arsha.core.domain.model.Meal

object DataMapper {
    fun mapResponsesToEntities(input: List<MealResponse>): List<MealEntity> {
        val mealList = ArrayList<MealEntity>()
        input.map {
            val meal = MealEntity(
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strMeal = it.strMeal,
                strArea = it.strArea,
                strYoutube = it.strYoutube,
                strMealThumb = it.strMealThumb,
                isFavorite = false
            )
            mealList.add(meal)
        }
        return mealList
    }

    fun mapEntitiesToDomain(input: List<MealEntity>): List<Meal> =
        input.map {
            Meal(
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strMeal = it.strMeal,
                strArea = it.strArea,
                strYoutube = it.strYoutube,
                strMealThumb = it.strMealThumb,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Meal) = MealEntity(
        idMeal = input.idMeal,
        strInstructions = input.strInstructions,
        strMeal = input.strMeal,
        strArea = input.strArea,
        strYoutube = input.strYoutube,
        strMealThumb = input.strMealThumb,
        isFavorite = input.isFavorite
    )
}