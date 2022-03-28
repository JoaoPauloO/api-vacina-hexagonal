package com.example.infrastructure.mapper

import com.example.core.model.VaccineApplication
import com.example.infrastructure.entity.VaccineApplicationJpa
import io.micronaut.context.annotation.Prototype

@Prototype
class VaccineApplicationMapperImpl(
    private val userJpaMapper: UserJpaMapper
) : VaccineApplicationJpaMapper {
    override fun toVaccineApplication(vaccJpa: VaccineApplicationJpa): VaccineApplication {
        return VaccineApplication(
            vaccineName = vaccJpa.vaccineName,
            user = userJpaMapper.toUser(vaccJpa.userJpa)
        ).apply {
            id = vaccJpa.id
        }
    }

    override fun toVaccineJpa(vacc: VaccineApplication): VaccineApplicationJpa {
        return VaccineApplicationJpa(
            vaccineName = vacc.vaccineName,
            userJpa = userJpaMapper.toUserJpaManaged(user = vacc.user)
        )
    }
}