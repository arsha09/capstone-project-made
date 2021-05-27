package id.arsha.capstoneakhir.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.arsha.core.domain.usecase.MealUseCase

class HomeViewModel(mealUseCase: MealUseCase) : ViewModel() {
    val meal = mealUseCase.getAllMeal().asLiveData()
}