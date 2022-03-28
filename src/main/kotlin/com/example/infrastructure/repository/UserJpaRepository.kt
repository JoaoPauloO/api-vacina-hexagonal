package com.example.infrastructure.repository

import com.example.infrastructure.entity.UserJpa
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UserJpaRepository : JpaRepository<UserJpa, Long> {
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): UserJpa?
}