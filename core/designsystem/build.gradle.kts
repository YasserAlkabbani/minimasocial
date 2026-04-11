plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.minimasocial.android.library.compose)
}

android {
    namespace = "com.yasser.minimasocial.core.designsystem"
}

dependencies {

//    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.material3)
//    api(libs.androidx.compose.adaptive)
//    api(libs.androidx.compose.ui)

    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}