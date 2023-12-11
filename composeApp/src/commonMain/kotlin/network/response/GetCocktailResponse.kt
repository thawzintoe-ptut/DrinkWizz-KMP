package network.response

import kotlinx.serialization.Serializable

@Serializable
data class GetCocktailResponse(
    var drinks: List<CocktailResponse> = emptyList()
)
