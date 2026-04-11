plugins {
    alias(libs.plugins.minimasocial.android.library)
}

android {
    namespace = "com.yasser.minimasocial.core.domain"
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.model)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}