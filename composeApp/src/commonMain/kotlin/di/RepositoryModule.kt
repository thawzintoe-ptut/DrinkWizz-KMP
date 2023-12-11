package di

import org.koin.dsl.module
import repository.DrinkWizzRepository

val repositoryModule = module {
    single<DrinkWizzRepository> { DrinkWizzRepository(get()) }
}
