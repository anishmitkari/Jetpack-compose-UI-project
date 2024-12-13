plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}


android {
    namespace = "com.anish.jetpackcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anish.jetpackcompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        allWarningsAsErrors = false

    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
        kotlinCompilerVersion ="1.6.21"

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation ("androidx.compose.material:material:1.7.5")
    implementation ("androidx.compose.material:material-icons-core:1.7.5")
    implementation ("androidx.compose.material:material-icons-extended:1.7.5")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    implementation ("androidx.activity:activity-compose:1.9.0")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.4.2")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.2")
    implementation ("com.airbnb.android:lottie-compose:6.0.0")

    implementation ("androidx.navigation:navigation-compose:2.7.1")

    implementation ("androidx.compose.runtime:runtime-livedata:1.6.8")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation("io.coil-kt:coil-compose:2.4.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.0.0")
    implementation ("androidx.compose.ui:ui:1.1.0")
    // mockito
    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0")
    testImplementation ("org.mockito:mockito-inline:2.25.0")
    testImplementation ("org.mockito:mockito-core:3.9.0") // Mockito framework
    implementation ("androidx.navigation:navigation-compose:2.8.4")


}