plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    viewBinding{
        enable  = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //noinspection GradleCompatible,GradleCompatible,GradleCompatible


    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    // hilt
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation ("androidx.fragment:fragment-ktx:1.5.2")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    //viewmodel lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    //lottie
    implementation ("com.airbnb.android:lottie:3.4.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")


    //viewpager
    implementation ("androidx.viewpager:viewpager:1.0.0")

    //dotindicator
    implementation ("com.tbuonomo:dotsindicator:4.2")

    //paging 3
    val paging_version = "3.2.1"

    implementation ("androidx.paging:paging-runtime:$paging_version")
    testImplementation ("androidx.paging:paging-common:$paging_version")
    implementation ("androidx.paging:paging-rxjava2:$paging_version")
    implementation ("androidx.paging:paging-rxjava3:$paging_version")

    //recycleranimation
    implementation ("jp.wasabeef:recyclerview-animators:4.0.2")

     //    interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.7.2")

    implementation ("androidx.activity:activity-ktx:1.7.1")



}
kapt{
    correctErrorTypes  = true
}
