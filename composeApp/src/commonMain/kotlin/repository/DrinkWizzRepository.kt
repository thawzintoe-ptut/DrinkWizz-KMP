package repository

import di.isNetworkAvailable
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import network.DrinkWizzError
import network.ErrorCode
import network.Resource
import network.response.CocktailResponse
import network.response.GetCocktailResponse

typealias CocktailList = List<CocktailResponse>

class DrinkWizzRepository(private val httpClient: HttpClient) {
    private fun HttpRequestBuilder.getCocktailCategories(
        name: String
    ) {
        url {
            parameter("c", name)
        }
    }

    fun fetchCocktailWithFilter(): Flow<Resource<CocktailList?>> {
        return makeSafeApiCall {
            val response = httpClient.get {
                getCocktailCategories("Cocktail")
            }.body<GetCocktailResponse>()
            Resource.success(response.drinks)
        }
    }

    private fun <T> makeSafeApiCall(api: suspend () -> Resource<T>) = flow {
        try {
            emit(Resource.loading())
            if (isNetworkAvailable()) {
                val response = api.invoke()
                emit(Resource.success(response.data))
            } else {
                emit(
                    Resource.error(error = DrinkWizzError(code = ErrorCode.NETWORK_NOT_AVAILABLE))
                )
            }
        } catch (ex: Exception) {
            emit(Resource.error(error = DrinkWizzError(code = ErrorCode.NETWORK_CONNECTION_FAILED)))
        }
    }
}
