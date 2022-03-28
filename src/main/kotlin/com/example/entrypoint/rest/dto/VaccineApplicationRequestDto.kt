package com.example.entrypoint.rest.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
class VaccineApplicationRequestDto(
    @field:NotBlank
    val name: String,

    @field:Email
    val userEmail: String
) {
}