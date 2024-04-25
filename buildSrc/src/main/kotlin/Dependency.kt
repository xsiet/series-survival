object Dependency {
    const val KOTLIN_VERSION = "1.9.22"
    const val PAPER_VERSION = "1.20.1"
    const val PAPER_API_VERSION = "1.20"
    private const val TAP_VERSION = "4.9.8"
    private const val KOMMAND_VERSION = "3.1.7"
    private const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${KOTLIN_VERSION}"
    private const val KOTLINX_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0"
    private const val TAP_API = "io.github.monun:tap-api:${TAP_VERSION}"
    private const val TAP_CORE = "io.github.monun:tap-core:${TAP_VERSION}"
    private const val KOMMAND_API = "io.github.monun:kommand-api:${KOMMAND_VERSION}"
    private const val KOMMAND_CORE = "io.github.monun:kommand-core:${KOMMAND_VERSION}"
    val Repositories = arrayListOf(
        "https://repo.codemc.org/repository/maven-public"
    )
    val Libraries = arrayListOf(
        KOTLIN_STDLIB,
        KOTLINX_COROUTINES_CORE,
        TAP_API,
        KOMMAND_API
    )
    val PaperLibraries = arrayListOf(
        KOTLIN_STDLIB,
        KOTLINX_COROUTINES_CORE,
        TAP_CORE,
        KOMMAND_CORE
    )
}