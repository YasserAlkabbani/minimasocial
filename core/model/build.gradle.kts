plugins {
    alias(libs.plugins.minimasocial.android.library)
}

android {
    namespace = "com.yasser.minimasocial.core.model"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}