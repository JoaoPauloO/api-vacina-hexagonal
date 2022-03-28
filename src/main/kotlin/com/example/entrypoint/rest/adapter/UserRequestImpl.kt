package com.example.entrypoint.rest.adapter

import com.example.core.model.User
import com.example.core.usecase.CreateUserUseCase
import com.example.core.port.UserRequest
import com.example.core.usecase.FindUserByIdUseCase
import io.micronaut.context.annotation.Prototype

@Prototype
class UserRequestImpl(
    private val createUserUseCase: CreateUserUseCase,
    private val findUserByIdUseCase: FindUserByIdUseCase
) : UserRequest {
    override fun registerUser(user: User) = createUserUseCase(user)
    override fun findById(userId: Long) = findUserByIdUseCase(userId)
}