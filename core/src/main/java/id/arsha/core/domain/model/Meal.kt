package id.arsha.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strInstructions: String,
    val strArea: String,
    val strYoutube: String,
    val strMealThumb: String,
    val isFavorite: Boolean
) : Parcelable