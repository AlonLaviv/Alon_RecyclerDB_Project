plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.alon_recyclerdb_project"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.alon_recyclerdb_project"
        minSdk = 24
        targetSdk = 35
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
}

dependencies {
    implementation("androidx.room:room-runtime:2.6.1") {
        exclude(group = "com.intellij", module = "annotations")
    }
    annotationProcessor("androidx.room:room-compiler:2.6.1") {
        exclude(group = "com.intellij", module = "annotations")
    }
    implementation("org.jetbrains:annotations:13.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}