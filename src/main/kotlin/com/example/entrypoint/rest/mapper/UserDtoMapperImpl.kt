package com.example.entrypoint.rest.mapper

import com.example.core.model.User
import com.example.entrypoint.rest.dto.UserRequestDto
import com.example.entrypoint.rest.dto.UserResponseDto
import io.micronaut.context.annotation.Prototype

@Prototype
class UserDtoMapperImpl : UserDtoMapper {
    override fun toUser(request: UserRequestDto): User {
        return User(request.name, request.email, request.document, request.birthDate)
    }

    override fun toUserResponseDto(user: User): UserResponseDto {
        with(user) {
            return UserResponseDto(id!!, email, birthDate)
        }
    }
}