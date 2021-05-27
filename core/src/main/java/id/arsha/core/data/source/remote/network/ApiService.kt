package id.arsha.core.data.source.remote.network

import id.arsha.core.data.source.remote.response.ListMealResponse
import retrofit2.http.GET

interface ApiService {
    @GET("search.php?s=Chicken")
    suspend fun getList(): ListMealResponse
}