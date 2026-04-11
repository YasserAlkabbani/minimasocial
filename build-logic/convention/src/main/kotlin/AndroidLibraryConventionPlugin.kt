import com.android.build.api.dsl.LibraryExtension
import com.yasser.minimasocial.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            apply(plugin="com.android.library")

            extensions.configure<LibraryExtension>{
                configureAndroidKotlin(this)
                testOptions.targetSdk = 36
            }
            dependencies {

            }
        }
    }
}