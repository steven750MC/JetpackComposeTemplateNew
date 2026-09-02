plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        applicationId = "dev.burnoo.template"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.jetpackComposeCompiler.get()
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
    languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
}

configurations.all {
    resolutionStrategy {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":ui:home"))
    implementation(libs.jetpackCompose.material3)
    implementation(libs.jetpackCompose.uiTooling.preview)
    implementation(libs.jetpackCompose.navigation)
    implementation(libs.activity.compose)
    debugImplementation(libs.jetpackCompose.uiTooling)

    testImplementation(kotlin("test"))
    testImplementation(libs.kotest.assertions)

    debugImplementation(libs.jetpackCompose.uiTest.manifest)
    androidTestImplementation(libs.jetpackCompose.uiTest.junit)
    androidTestImplementation(libs.test.androidCore)

implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // ViewModel در Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation("androidx.core:core-ktx:1.13.1")

    // کوروتین‌ها (اگر از قبل نیست)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

}
