package com.thoughtworks.device_control.service

import com.thoughtworks.device_control.dto.DeviceDTO
import com.thoughtworks.device_control.repository.DeviceRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class DeviceService(val deviceRepository: DeviceRepository) {

    companion object : KLogging()

    fun getAllDevices(): List<DeviceDTO> {
        logger.info("Getting all devices...")
        return deviceRepository.findAll()
            .map { d -> d.let { DeviceDTO(it.id, it.name, it.brand, it.model, it.os) } }
    }
}