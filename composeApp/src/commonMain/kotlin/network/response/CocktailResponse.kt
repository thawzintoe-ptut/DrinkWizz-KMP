package network.response

import kotlinx.serialization.Serializable

@Serializable
data class CocktailResponse(
    val strDrink: String? = null,
    val strDrinkThumb: String? = null,
    val idDrink: String? = null
)
