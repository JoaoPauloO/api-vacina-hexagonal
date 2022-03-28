package com.example.infrastructure.adapter

import com.example.core.model.VaccineApplication
import com.example.core.port.VaccineApplicationRepository
import com.example.infrastructure.mapper.VaccineApplicationJpaMapper
import com.example.infrastructure.repository.VaccineApplicationJpaRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class VaccineApplicationRepositoryImpl(
    private val vaccRepositoryJpa: VaccineApplicationJpaRepository,
    private val mapper: VaccineApplicationJpaMapper
) : VaccineApplicationRepository {
    override fun save(vacc: VaccineApplication): VaccineApplication {
        val vaccJpa = mapper.toVaccineJpa(vacc = vacc)
        vaccRepositoryJpa.save(vaccJpa)
        return mapper.toVaccineApplication(vaccJpa)
    }
}