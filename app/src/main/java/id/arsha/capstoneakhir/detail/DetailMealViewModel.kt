package id.arsha.capstoneakhir.detail

import androidx.lifecycle.ViewModel
import id.arsha.core.domain.model.Meal
import id.arsha.core.domain.usecase.MealUseCase

class DetailMealViewModel(private val mealUseCase: MealUseCase) : ViewModel() {
    fun setFavoriteMeal(meal: Meal, newStatus:Boolean) = mealUseCase.setFavoriteMeal(meal, newStatus)
}

