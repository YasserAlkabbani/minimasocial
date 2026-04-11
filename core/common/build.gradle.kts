plugins {
    alias(libs.plugins.minimasocial.android.library)
}

android {
    namespace = "com.yasser.minimasocial.core.common"
}

dependencies {

    implementation(libs.kotlinx.coroutines)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}