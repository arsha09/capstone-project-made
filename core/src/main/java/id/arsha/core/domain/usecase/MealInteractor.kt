package id.arsha.core.domain.usecase

import id.arsha.core.domain.model.Meal
import id.arsha.core.domain.repository.IMealRepository

class MealInteractor(private val mealRepository: IMealRepository): MealUseCase {

    override fun getAllMeal() = mealRepository.getAllMeal()

    override fun getFavoriteMeal() = mealRepository.getFavoriteMeal()

    override fun setFavoriteMeal(meal: Meal, state: Boolean) = mealRepository.setFavoriteMeal(meal, state)
}