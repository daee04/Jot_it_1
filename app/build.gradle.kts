plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.jotitbyshahidaminbhat"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.jotitbyshahidaminbhat"
        minSdk = 26
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // RoomDatabase
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

// Coroutines
   val coroutinesVersion = "1.6.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

// Navigation Component
    val navVersion = "2.7.3" // same as in build.gradle (:project)
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")


    // FOR ROOM DATA-BASE
    //implementation ("androidx.room:room-runtime: 2.4.0")
    // To use Kotlin annotation processing tool (kapt)
   // kapt("androidx.room:room-compiler:2.5.2")

    //for coroutines (run in background thread)
   // implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
   // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")


    //FOR NAVIGATION OF FRAGMENTS
    //implementation("androidx.navigation:navigation-fragment-ktx:2.7.3")
  //  implementation("androidx.navigation:navigation-ui-ktx:2.7.3")

    val lifeCycleVersion = "2.6.2"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion")


    // Annotation processor
    kapt ("androidx.lifecycle:lifecycle-compiler:$lifeCycleVersion")



    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.2")




}