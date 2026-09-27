import java.util.Properties

plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.minimasocial.hilt)
}

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) localProperties.load(localPropertiesFile.inputStream())

android {
    namespace = "com.yasser.minimasocial.core.network"

    buildFeatures {
        buildConfig = true
    }
    buildTypes {
        release {
            buildConfigField(
                "String",
                "SUPABASE_URL",
                localProperties.getProperty("SUPABASE_URL") ?: "\"\""
            )
            buildConfigField(
                "String",
                "SUPABASE_KEY",
                localProperties.getProperty("SUPABASE_PUBLISHABLE_KEY") ?: "\"\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "SUPABASE_URL",
                localProperties.getProperty("SUPABASE_URL") ?: "\"\""
            )
            buildConfigField(
                "String",
                "SUPABASE_KEY",
                localProperties.getProperty("SUPABASE_PUBLISHABLE_KEY") ?: "\"\""
            )
        }
    }

}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.datastore)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}