package id.arsha.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.arsha.core.domain.usecase.MealUseCase

class FavoriteViewModel(mealUseCase: MealUseCase) : ViewModel() {
    val favoriteMeal = mealUseCase.getFavoriteMeal().asLiveData()
}