package com.thoughtworks.device_control.entity

import com.thoughtworks.device_control.enums.OS
import com.thoughtworks.device_control.repository.DeviceRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import kotlin.test.assertTrue

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DeviceTest2(@Autowired private val deviceRepository: DeviceRepository) {

    companion object {
        val db = PostgreSQLContainer("postgres")

        @BeforeAll
        @JvmStatic
        fun startDBContainer(): Unit {
            db.start()
        }

        @AfterAll
        @JvmStatic
        fun stopDBContainer() {
            db.stop()
        }

        @DynamicPropertySource
        @JvmStatic
        fun registerDBContainer(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", db::getJdbcUrl)
            registry.add("spring.datasource.username", db::getUsername)
            registry.add("spring.datasource.password", db::getPassword)
        }
    }


    @Test
    fun `dbContainer is running`() {
        assertTrue(db.isRunning)
    }

    @Test
    fun `id is generated when a genre is persisted`() {
        val device = Device(null, "Device 1", "Apple", "Iphone 14", OS.IOS)
        assertThat(device.id).isNull()
        deviceRepository.save(device)
        assertThat(device.id).isNotEqualTo(0L)
    }
}