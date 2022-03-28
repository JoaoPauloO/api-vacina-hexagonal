package com.example.infrastructure.adapter

import com.example.core.model.User
import com.example.core.port.UserRepository
import com.example.infrastructure.exception.UserJpaNotExistsException
import com.example.infrastructure.mapper.UserJpaMapper
import com.example.infrastructure.repository.UserJpaRepository
import io.micronaut.context.annotation.Prototype

@Prototype
class UserRepositoryImpl(
    private val repositoryJpa: UserJpaRepository,
    private val mapper: UserJpaMapper
) : UserRepository {

    override fun save(user: User): User {
        val userJpa = mapper.toUserJpaUnmanaged(user)
        repositoryJpa.save(userJpa)
        return mapper.toUser(userJpa)
    }

    override fun findByEmail(email: String): User {
        val userJpa = repositoryJpa.findByEmail(email) ?: throw UserJpaNotExistsException()
        return mapper.toUser(userJpa)
    }

    override fun existsUser(email: String): Boolean {
        return repositoryJpa.existsByEmail(email)
    }

    override fun findById(userId: Long): User {
        try {
            val userOptional = repositoryJpa.findById(userId)
            val userJpa = userOptional.get()
            return mapper.toUser(userJpa)
        } catch (ex: Exception) {
            throw UserJpaNotExistsException()
        }
    }
}