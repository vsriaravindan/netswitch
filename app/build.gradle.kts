plugins {
    id("com.android.application")
}

android {
    namespace = "com.sri.netswitch"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sri.netswitch"
        minSdk = 26
        targetSdk = 36
        versionCode = 3
        versionName = "1.2"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
