plugins {
    alias(libs.plugins.minimasocial.android.library.compose)
    alias(libs.plugins.minimasocial.feature.impl)
}

android {
    namespace = "com.yasser.minimasocial.feature.post.details.impl"
}

dependencies {
    implementation(projects.feature.post.details.api)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.common)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}