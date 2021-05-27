package id.arsha.core.data.source.remote

import android.util.Log
import id.arsha.core.data.source.remote.network.ApiResponse
import id.arsha.core.data.source.remote.network.ApiService
import id.arsha.core.data.source.remote.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMeal(): Flow<ApiResponse<List<MealResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.meals
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.meals))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}