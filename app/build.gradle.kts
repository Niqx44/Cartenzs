plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    kotlin("android") version "1.9.0"
}

android {
    namespace = "com.example.cartenzs"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cartenzs"
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

    buildFeatures {

        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation("androidx.vectordrawable:vectordrawable-animated:1.1.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation(platform(libs.firebase.bom))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth:23.1.0")
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.google.android.gms:play-services-auth:21.3.0")
    implementation(libs.firebase.auth)
    annotationProcessor(libs.glideCompiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}