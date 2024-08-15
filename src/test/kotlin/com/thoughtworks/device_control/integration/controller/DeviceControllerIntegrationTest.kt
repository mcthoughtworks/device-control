package com.thoughtworks.device_control.integration.controller

import com.thoughtworks.device_control.dto.DeviceDTO
import com.thoughtworks.device_control.repository.DeviceRepository
import com.thoughtworks.device_control.util.deviceEntityList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class DeviceControllerIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var deviceRepository: DeviceRepository

    @BeforeEach
    fun setUp() {
        deviceRepository.deleteAll()
        val devices = deviceEntityList()
        deviceRepository.saveAll(devices)
    }

    @Test
    fun getDeviceInfo() {
        val result = webTestClient.get()
            .uri("/v1/devices")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBodyList(DeviceDTO::class.java)
            .returnResult().responseBody
        assertEquals(3, result!!.size)
    }
}