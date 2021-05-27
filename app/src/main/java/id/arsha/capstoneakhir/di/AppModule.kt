package id.arsha.capstoneakhir.di

import id.arsha.core.domain.usecase.MealInteractor
import id.arsha.core.domain.usecase.MealUseCase
import id.arsha.capstoneakhir.detail.DetailMealViewModel
import id.arsha.capstoneakhir.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MealUseCase> { MealInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMealViewModel(get()) }
}