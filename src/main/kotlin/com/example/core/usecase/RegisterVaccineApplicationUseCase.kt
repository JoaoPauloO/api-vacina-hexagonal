package com.example.core.usecase

import com.example.core.exception.UnmanagedVaccineApplicationException
import com.example.core.model.VaccineApplication
import com.example.core.port.VaccineApplicationRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class RegisterVaccineApplicationUseCase(
    private val vaccRepository: VaccineApplicationRepository
) {

    operator fun invoke(vacc: VaccineApplication): Long {
        return vaccRepository.save(vacc).id.let {
            return@let it
        } ?: throw UnmanagedVaccineApplicationException()
    }
}