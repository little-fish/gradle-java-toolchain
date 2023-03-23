package foo.bar

import foo.bar.resolver.SomeResolver
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.jvm.toolchain.JavaToolchainResolverRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject

abstract class JavaToolchainResolverPlugin : Plugin<Settings> {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(JavaToolchainResolverPlugin::class.java)
    }

    @get:Inject
    protected abstract val javaToolchainResolverRegistry: JavaToolchainResolverRegistry

    override fun apply(settings: Settings) {
        LOG.info("Start applying the plugin into '${settings.settingsDir.absolutePath}'.")

        settings.plugins.apply("jvm-toolchain-management")
        javaToolchainResolverRegistry.register(SomeResolver::class.java)

        LOG.info("Plugin applied.")
    }
}
