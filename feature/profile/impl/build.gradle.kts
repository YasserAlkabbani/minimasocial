plugins {
    alias(libs.plugins.minimasocial.android.library.compose)
    alias(libs.plugins.minimasocial.feature.impl)
}

android {
    namespace = "com.yasser.minimasocial.feature.profile.impl"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.feature.profile.api)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}