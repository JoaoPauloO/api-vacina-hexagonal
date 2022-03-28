package com.example.entrypoint.rest.mapper

import com.example.core.model.User
import com.example.core.model.VaccineApplication
import com.example.entrypoint.rest.dto.VaccineApplicationRequestDto
import io.micronaut.context.annotation.Prototype

@Prototype
class VaccineApplicationMapperImpl : VaccineApplicationMapper {
    override fun toVaccineApplication(request: VaccineApplicationRequestDto, user: User): VaccineApplication {
        with(request) {
            return VaccineApplication(
                vaccineName =  name,
                user = user
            )
        }
    }
}