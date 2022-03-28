package com.example.core.usecase

import com.example.core.exception.UnmanagedUserException
import com.example.core.exception.UserExistException
import com.example.core.model.User
import com.example.core.port.UserRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class CreateUserUseCase(
    private val repository: UserRepository
) {

    operator fun invoke(user: User): Long {
        val isUserAlreadyRegistered = repository.existsUser(user.email)

        if(isUserAlreadyRegistered) {
            throw UserExistException()
        }

        return repository.save(user).id.let {
            return@let it
        } ?: throw UnmanagedUserException()
    }
}