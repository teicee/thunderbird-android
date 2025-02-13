import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project

fun SpotlessExtension.configureKotlinCheck(
    targets: List<String>,
    project: Project,
    libs: LibrariesForLibs,
) {
    kotlin {
        ktlint(libs.versions.ktlint.get())
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")
            .editorConfigOverride(kotlinEditorConfigOverride)
        target(targets)
        targetExclude(
            "**/build/",
        )
    }
}

fun SpotlessExtension.configureKotlinGradleCheck(
    targets: List<String>,
    project: Project,
    libs: LibrariesForLibs,
) {
    kotlinGradle {
        ktlint(libs.versions.ktlint.get())
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")
            .editorConfigOverride(
                mapOf(
                    "ktlint_standard_function-signature" to "disabled",
                )
            )
        target(targets)
        targetExclude("**/build/")
    }
}

fun SpotlessExtension.configureMarkdownCheck(
    targets: List<String>,
) {
    format("markdown") {
        prettier()
        target(targets)
        targetExclude(
            "**/build/",
        )
    }
}

fun SpotlessExtension.configureMiscCheck() {
    format("misc") {
        target(
            "*.gradle",
            ".gitignore",
        )
        trimTrailingWhitespace()
    }
}

val kotlinEditorConfigOverride = mapOf(
    "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
    "ktlint_standard_property-naming" to "disabled",
    "ktlint_standard_function-signature" to "disabled",
    "ktlint_standard_parameter-list-spacing" to "disabled",
    "ktlint_ignore_back_ticked_identifier" to "true",
)
