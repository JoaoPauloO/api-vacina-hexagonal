package com.example.entrypoint.rest.dto

import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
class UserRequestDto(
    @field:NotBlank
    val name: String,

    @field:Email
    @field:NotBlank
    val email: String,

    @field:CPF
    val document: String,

    @field:NotNull
    val birthDate: LocalDate
)