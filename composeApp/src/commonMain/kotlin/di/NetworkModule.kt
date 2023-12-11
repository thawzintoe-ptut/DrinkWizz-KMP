package di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

object DrinkWizzNetwork {
    const val URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php"
    object EndPoint {
        const val CATEGORY_LIST = "filter.php?c=Cocktail"
    }
}

val networkModule = module {
    single {
        HttpClient {
            defaultRequest {
                url {
                    takeFrom(DrinkWizzNetwork.URL)
                }
            }
            expectSuccess = true
            install(HttpTimeout) {
                val timeout = 30000L
                connectTimeoutMillis = timeout
                requestTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }
            install(Logging) {
                level = LogLevel.BODY
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
}

fun isNetworkAvailable(): Boolean {
    return true
}
