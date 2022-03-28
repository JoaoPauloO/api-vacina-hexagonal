package com.example.infrastructure.mapper

import com.example.core.model.VaccineApplication
import com.example.infrastructure.entity.UserJpa
import com.example.infrastructure.entity.VaccineApplicationJpa

interface VaccineApplicationJpaMapper {
    fun toVaccineApplication(vaccJpa: VaccineApplicationJpa): VaccineApplication
    fun toVaccineJpa(vacc: VaccineApplication): VaccineApplicationJpa
}