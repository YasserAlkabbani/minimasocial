plugins {
    alias(libs.plugins.minimasocial.android.library.compose)
    alias(libs.plugins.minimasocial.feature.impl)
}

android {
    namespace = "com.yasser.minimasocial.feature.auth.splash.impl"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.ui)

    implementation(projects.feature.auth.splash.api)
    implementation(projects.feature.auth.login.api)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}