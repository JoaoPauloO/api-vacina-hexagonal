package com.example.infrastructure.mapper

import com.example.core.model.User
import com.example.infrastructure.entity.UserJpa

interface UserJpaMapper {
    fun toUser(userJpa: UserJpa): User
    fun toUserJpaUnmanaged(user: User): UserJpa
    fun toUserJpaManaged(user: User): UserJpa
}