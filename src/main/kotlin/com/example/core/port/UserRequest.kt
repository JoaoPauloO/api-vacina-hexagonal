package com.example.core.port

import com.example.core.model.User
import io.micronaut.context.annotation.Prototype

@Prototype
interface UserRequest {
    fun registerUser(user: User): Long
    fun findById(userId: Long): User
}