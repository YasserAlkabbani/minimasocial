plugins {
    alias(libs.plugins.minimasocial.feature.api)
}

android {
    namespace = "com.yasser.minimasocial.feature.auth.splash.api"
}

dependencies{

    implementation(projects.core.data)
    implementation(projects.feature.auth.login.api)

}