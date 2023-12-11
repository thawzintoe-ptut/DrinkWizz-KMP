package feature.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import network.DrinkWizzError
import network.Resource
import repository.DrinkWizzRepository

/**
 * Defined all possible states here
 * */
sealed class HomeScreenState {
    data object Loading : HomeScreenState()
    data object Empty : HomeScreenState()
    data class Error(val error: DrinkWizzError) : HomeScreenState()
    data class Success(val cocktailList: List<CocktailVO>) : HomeScreenState()
}

/**
 * Additional data states to hold all possible data
 * */

private data class HomeState(
    val isLoading: Boolean = false,
    val error: DrinkWizzError? = null,
    val cocktailList: List<CocktailVO>? = null
) {
    fun toUiState(): HomeScreenState {
        return if (isLoading) {
            HomeScreenState.Loading
        } else if (error != null) {
            HomeScreenState.Error(error)
        } else {
            cocktailList?.let {
                HomeScreenState.Success(it)
            } ?: HomeScreenState.Empty
        }
    }
}

class HomeViewModel(drinkWizzRepository: DrinkWizzRepository) : ScreenModel {
    private val _homeState = MutableStateFlow(HomeState())

    val uiState: StateFlow<HomeScreenState> =
        drinkWizzRepository.fetchCocktailWithFilter()
            .catch {
                println("Error: $it")
                _homeState.update { it.copy(isLoading = false, error = it.error) }
            }
            .map { response ->
                when (response.status) {
                    Resource.Status.ERROR -> {
                        _homeState.update { it.copy(isLoading = false, error = response.error) }
                    }

                    Resource.Status.LOADING -> {
                        _homeState.update { it.copy(isLoading = true) }
                    }

                    else -> {
                        _homeState.update {
                            it.copy(
                                isLoading = false,
                                error = null,
                                cocktailList = response.data?.map(
                                    CocktailVOMapper::map
                                )
                            )
                        }
                    }
                }
                _homeState.value.toUiState()
            }.stateIn(
                coroutineScope,
                SharingStarted.WhileSubscribed(500L),
                HomeScreenState.Loading
            )
}
