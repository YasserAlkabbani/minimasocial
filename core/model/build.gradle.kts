plugins {
    alias(libs.plugins.minimasocial.android.library)
}

android {
    namespace = "com.yasser.minimasocial.core.model"
}

dependencies {

    implementation(projects.core.common)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}