package com.thoughtworks.device_control.repository

import com.thoughtworks.device_control.entity.Device
import org.springframework.data.repository.CrudRepository

interface DeviceRepository : CrudRepository<Device, Int> {
}