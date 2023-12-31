plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-parcelize'
    id 'kotlin-kapt'
}

android {
    compileSdk 32
    buildFeatures{
        viewBinding true
        dataBinding true
    }

    defaultConfig {
        applicationId "com.example.foodorderingapp"
        minSdk 21
        targetSdk 32
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField 'String', 'BASE_URL', '"http://kasimadalan.pe.hu/"'
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
                targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

apply plugin: "com.google.gms.google-services"
apply plugin: "androidx.navigation.safeargs.kotlin"
apply plugin: "kotlin-kapt"
apply plugin: "dagger.hilt.android.plugin"

dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.1'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    def coroutines_version = "1.5.2"
    def retrofit_version = "2.9.0"
    def koin_version = "2.0.1"
    def okhttp3_version = "5.0.0-alpha.2"
    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version"
    //Firebase
    //implementation platform('com.google.firebase:firebase-bom:30.3.1')
    implementation'com.google.firebase:firebase-auth-ktx:21.0.6'

    implementation "androidx.lifecycle:lifecycle-viewmodel:2.5.0"
    implementation "androidx.activity:activity-ktx:1.5.0"

    implementation "com.google.dagger:hilt-android:2.42"
    kapt "com.google.dagger:hilt-android-compiler:2.42"


    implementation 'com.squareup.picasso:picasso:2.71828'

    //Koin
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"
    implementation "org.koin:koin-android:$koin_version"
    implementation "org.koin:koin-androidx-scope:$koin_version"
    implementation "org.koin:koin-androidx-viewmodel:$koin_version"

    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$okhttp3_version"

    implementation 'com.github.fornewid:neumorphism:0.3.2'

    implementation 'com.github.santalu:maskara:1.0.0'


}