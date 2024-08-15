package com.thoughtworks.device_control

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<DeviceControlApplication>().with(TestcontainersConfiguration::class).run(*args)
}
