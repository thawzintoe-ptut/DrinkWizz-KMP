plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization")
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.sqldelight)
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.kotlinx.serialization.json)

//            api(libs.moko.resources)
//            api(libs.moko.resources.compose)
            api(libs.mvvm.core) // only ViewModel, EventsDispatcher, Dispatchers.UI
            api(libs.mvvm.flow) // api mvvm-core, CFlow for native and binding extensions
            api(libs.mvvm.livedata) // api mvvm-core, LiveData and extensions
            api(libs.mvvm.state) // api mvvm-livedata, ResourceState class and extensions
            // compose multiplatform
            api(libs.mvvm.compose) // api mvvm-core, getViewModel for Compose Multiplatfrom
            api(libs.mvvm.flow.compose) // api mvvm-flow, binding extensions for Compose Multiplatfrom
            api(libs.mvvm.livedata.compose) // api mvvm-livedata, binding extensions for Compose Multiplatfrom

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)

            api(libs.sqlDelight.adapter)
            api(libs.sqlDelight.coroutine)

            api(libs.image.loader)
            api(libs.voyager.navigator)

            // koin
            api(libs.koin.core)
            api(libs.koin.compose)
        }
    }
}

android {
    namespace = "org.ptut.drinkwizz.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
