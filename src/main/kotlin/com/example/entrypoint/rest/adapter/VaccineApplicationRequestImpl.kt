package com.example.entrypoint.rest.adapter

import com.example.core.model.VaccineApplication
import com.example.core.port.VaccineApplicationRequest
import com.example.core.usecase.RegisterVaccineApplicationUseCase
import io.micronaut.context.annotation.Prototype

@Prototype
class VaccineApplicationRequestImpl(
    private val useCase: RegisterVaccineApplicationUseCase
) : VaccineApplicationRequest {
    override fun registerVaccineApplication(vacc: VaccineApplication) = useCase(vacc)
}