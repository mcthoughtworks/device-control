package com.thoughtworks.device_control.unit.controller

import com.ninjasquad.springmockk.MockkBean
import com.thoughtworks.device_control.dto.DeviceDTO
import com.thoughtworks.device_control.service.DeviceService
import com.thoughtworks.device_control.util.deviceDTOList
import io.mockk.every
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class DeviceControllerUnitTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var deviceServiceMock: DeviceService

    @Test
    fun getDeviceInfo() {

        every { deviceServiceMock.getAllDevices() } returns deviceDTOList()

        mockMvc.perform(get("/v1/devices"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath<List<DeviceDTO>>("$", hasSize(3)))
    }
}