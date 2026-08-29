plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.minimasocial.hilt)
}

android {
    namespace = "com.yasser.minimasocial.core.domain"
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.common)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}