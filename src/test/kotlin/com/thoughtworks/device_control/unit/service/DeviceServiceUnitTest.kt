package com.thoughtworks.device_control.unit.service

import com.ninjasquad.springmockk.MockkBean
import com.thoughtworks.device_control.repository.DeviceRepository
import com.thoughtworks.device_control.service.DeviceService
import com.thoughtworks.device_control.util.deviceEntityList
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class DeviceServiceUnitTest {

    @Autowired
    lateinit var deviceService: DeviceService

    @MockkBean
    lateinit var deviceRepository: DeviceRepository

    @Test
    fun getAllDevices() {
        every { deviceRepository.findAll() } returns deviceEntityList()

        val devices = deviceService.getAllDevices()
        assertEquals(3, devices.size)
    }

}