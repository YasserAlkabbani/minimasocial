plugins {
    alias(libs.plugins.minimasocial.android.library)
    alias(libs.plugins.minimasocial.hilt)
}

android {
    namespace = "com.yasser.minimasocial.core.datastore"

}

dependencies {
    implementation(projects.core.common)

    implementation(libs.datastore.preferences)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}