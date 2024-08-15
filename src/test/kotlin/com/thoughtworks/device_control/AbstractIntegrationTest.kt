package com.thoughtworks.device_control

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.containers.PostgreSQLContainer
import kotlin.test.assertTrue

@SpringBootTest
@ContextConfiguration(initializers = [AbstractIntegrationTest.Initializer::class])
@AutoConfigureMockMvc
abstract class AbstractIntegrationTest {
    companion object {
        val postgresDB = PostgreSQLContainer("postgres")
    }

    internal class Initializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
            postgresDB.start()

            TestPropertyValues.of(
                "spring.datasource.url=${postgresDB::getJdbcUrl}",
                "spring.datasource.username=${postgresDB::getUsername}",
                "spring.datasource.password=${postgresDB::getPassword}",
            ).applyTo(configurableApplicationContext.environment)
        }
    }

    @Test
    fun `dbContainer is running`() {
        assertTrue(postgresDB.isRunning)
    }
}