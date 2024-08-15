package com.thoughtworks.device_control.dto

import com.thoughtworks.device_control.enums.OS

data class DeviceDTO(
    val id: Int?,
    val name: String,
    val brand: String,
    val model: String,
    val os: OS
)