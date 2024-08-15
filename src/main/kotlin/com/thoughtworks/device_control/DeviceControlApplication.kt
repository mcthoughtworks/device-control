package com.thoughtworks.device_control

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DeviceControlApplication

fun main(args: Array<String>) {
    runApplication<DeviceControlApplication>(*args)
}
