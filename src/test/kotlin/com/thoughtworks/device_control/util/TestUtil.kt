package com.thoughtworks.device_control.util

import com.thoughtworks.device_control.dto.DeviceDTO
import com.thoughtworks.device_control.entity.Device
import com.thoughtworks.device_control.enums.OS

fun deviceEntityList() = listOf(
    Device(null, "Device 1", "Apple", "Iphone 14", OS.IOS),
    Device(null, "Device 2", "Xiaomi", "Mi 14", OS.ANDROID),
    Device(null, "Device 3", "Apple", "Ipad Mini", OS.IOS)
)

fun deviceDTOList() = deviceEntityList()
    .map { d -> d.let { DeviceDTO(it.id, it.name, it.brand, it.model, it.os) } }