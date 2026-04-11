plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.minimasocial.android.library.compose)
}

android {
    namespace = "com.yasser.minimasocial.core.ui"
}

dependencies {

    api(projects.core.designsystem)
    api(projects.core.model)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}