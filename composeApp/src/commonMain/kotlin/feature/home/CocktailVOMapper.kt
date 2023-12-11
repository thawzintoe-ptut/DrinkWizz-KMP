package feature.home

import network.response.CocktailResponse

object CocktailVOMapper {
    fun map(cocktailResponse: CocktailResponse): CocktailVO {
        return CocktailVO(
            id = cocktailResponse.idDrink ?: "",
            cocktailName = cocktailResponse.strDrink ?: "",
            cocktailThumbnail = cocktailResponse.strDrinkThumb ?: ""
        )
    }
}
