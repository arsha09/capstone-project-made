package id.arsha.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMealResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("meals")
    val meals: List<MealResponse>
)