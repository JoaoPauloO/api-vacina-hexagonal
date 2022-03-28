package com.example.entrypoint.rest.dto

import java.time.LocalDate

class UserResponseDto(
    val id: Long,
    val email: String,
    val birthDate: LocalDate
) {
}