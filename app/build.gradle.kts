plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "app.talia.combiner"
    compileSdk = 36

    defaultConfig {
        applicationId = "app.talia.combiner"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.bundles.android.essential)
    implementation(libs.bundles.android.ui)
    implementation(platform(libs.androidx.compose.bom))

    // Projects
    implementation(project(":ui"))

    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.bundles.debug)
}
