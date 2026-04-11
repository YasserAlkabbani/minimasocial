plugins {
    alias(libs.plugins.minimasocial.android.library.compose)
    alias(libs.plugins.minimasocial.feature.impl)
}

android {
    namespace = "com.yasser.minimasocial.feature.search.impl"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.feature.search.api)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}