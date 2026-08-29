plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.yasser.minimasocial.core.common"
}

dependencies {

    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlinx.serialization)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}