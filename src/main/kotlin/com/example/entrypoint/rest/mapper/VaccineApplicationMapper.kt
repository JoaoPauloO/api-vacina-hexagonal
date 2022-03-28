package com.example.entrypoint.rest.mapper

import com.example.core.model.User
import com.example.core.model.VaccineApplication
import com.example.entrypoint.rest.dto.VaccineApplicationRequestDto

interface VaccineApplicationMapper {
    fun toVaccineApplication(request: VaccineApplicationRequestDto, user: User): VaccineApplication
}