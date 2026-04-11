import com.android.build.api.dsl.LibraryExtension
import com.yasser.minimasocial.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class FeatureImplConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {

            apply(plugin = "minimasocial.android.library")
            apply(plugin = "minimasocial.hilt")

            extensions.configure<LibraryExtension> {

            }

            dependencies {

                "implementation"(project(":core:ui"))
//                "implementation"(project(":core:designsystem"))

                "implementation"(libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                "implementation"(libs.findLibrary("androidx.lifecycle.viewmodel.compose").get())

                "implementation"(libs.findLibrary("hilt.ext.viewmodel.compose").get())

                "implementation"(libs.findLibrary("androidx.navigation3.runtime").get())


            }

        }

    }
}