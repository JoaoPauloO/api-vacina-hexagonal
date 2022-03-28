package com.example.entrypoint.rest.mapper

import com.example.core.model.User
import com.example.entrypoint.rest.dto.UserRequestDto
import com.example.entrypoint.rest.dto.UserResponseDto

interface UserDtoMapper {
    fun toUser(request: UserRequestDto): User
    fun toUserResponseDto(user: User): UserResponseDto
}