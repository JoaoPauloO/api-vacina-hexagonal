package com.example.entrypoint.rest.controller

import com.example.core.port.UserRepository
import com.example.core.port.VaccineApplicationRequest
import com.example.entrypoint.rest.dto.VaccineApplicationRequestDto
import com.example.entrypoint.rest.mapper.VaccineApplicationMapper
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.net.URI
import javax.validation.Valid

@Controller("api/v1")
@Validated
class VaccineApplicationController(
    private val userRepositoryPort: UserRepository,
    private val vaccPort: VaccineApplicationRequest,
    private val vaccMapper: VaccineApplicationMapper
) {

    @Post("/vaccine/application")
    fun registerVaccineApplication(@Valid @Body request: VaccineApplicationRequestDto): HttpResponse<Any> {
        val user = userRepositoryPort.findByEmail(request.userEmail)
        val vaccAppli = vaccMapper.toVaccineApplication(request = request, user = user)
        val vaccAppliId = vaccPort.registerVaccineApplication(vaccAppli)
        val uri = URI.create("http://localhost/api/v1/user/${vaccAppliId}")
        return HttpResponse.created(uri)
    }
}