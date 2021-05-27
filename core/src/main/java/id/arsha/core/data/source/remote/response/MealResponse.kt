package id.arsha.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @field:SerializedName("idMeal")
    val idMeal: String,

    @field:SerializedName("strMeal")
    val strMeal: String,

    @field:SerializedName("strInstructions")
    val strInstructions: String,

    @field:SerializedName("strArea")
    val strArea: String,

    @field:SerializedName("strYoutube")
    val strYoutube: String,

    @field:SerializedName("strMealThumb")
    val strMealThumb: String
)
