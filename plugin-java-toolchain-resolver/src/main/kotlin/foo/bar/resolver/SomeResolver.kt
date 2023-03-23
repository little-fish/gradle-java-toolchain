package foo.bar.resolver

import org.gradle.jvm.toolchain.JavaToolchainDownload
import org.gradle.jvm.toolchain.JavaToolchainRequest
import org.gradle.jvm.toolchain.JavaToolchainResolver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

abstract class SomeResolver : JavaToolchainResolver {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(SomeResolver::class.java)
    }

    override fun resolve(javaToolchainRequest: JavaToolchainRequest): Optional<JavaToolchainDownload> {
        LOG.info("Just the log..")

        return Optional.empty()
    }
}
