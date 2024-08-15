package com.thoughtworks.device_control.controller

import com.thoughtworks.device_control.dto.DeviceDTO
import com.thoughtworks.device_control.service.DeviceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/devices")
class DeviceController(val deviceService: DeviceService) {

    @GetMapping
    fun getAllDevices(): List<DeviceDTO> = deviceService.getAllDevices()
}