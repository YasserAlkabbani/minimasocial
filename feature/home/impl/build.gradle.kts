plugins {
    alias(libs.plugins.minimasocial.android.library.compose)
    alias(libs.plugins.minimasocial.feature.impl)
}

android {
    namespace = "com.yasser.minimasocial.feature.home.impl"
}

dependencies {
    implementation(projects.feature.home.api)
    implementation(projects.feature.post.details.api)
    implementation(projects.core.data)
    implementation(projects.core.domain)

    implementation(libs.paging.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}