package id.arsha.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "meal")
data class MealEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idMeal")
    var idMeal: String,

    @ColumnInfo(name = "strMeal")
    var strMeal: String,

    @ColumnInfo(name = "strInstructions")
    var strInstructions: String,

    @ColumnInfo(name = "strArea")
    var strArea: String,

    @ColumnInfo(name = "strYoutube")
    var strYoutube: String,

    @ColumnInfo(name = "strMealThumb")
    var strMealThumb: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
