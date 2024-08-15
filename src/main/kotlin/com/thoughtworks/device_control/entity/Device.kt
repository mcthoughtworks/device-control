package com.thoughtworks.device_control.entity

import com.thoughtworks.device_control.enums.OS
import jakarta.persistence.*

@Entity
@Table(name = "devices")
data class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    val name: String,
    val brand: String,
    val model: String,
    @Enumerated(EnumType.STRING)
    val os: OS
)