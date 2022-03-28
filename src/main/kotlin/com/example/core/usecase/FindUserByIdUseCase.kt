package com.example.core.usecase

import com.example.core.model.User
import com.example.core.port.UserRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class FindUserByIdUseCase(
    private val userRepository: UserRepository
) {

    operator fun invoke(userId: Long): User {
        return userRepository.findById(userId)
    }
}
