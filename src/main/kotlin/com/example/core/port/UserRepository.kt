package com.example.core.port

import com.example.core.model.User

interface UserRepository {
    fun save(user: User): User
    fun findByEmail(email: String): User
    fun existsUser(email: String): Boolean
    fun findById(userId: Long): User
}