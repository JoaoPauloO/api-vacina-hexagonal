package com.example.infrastructure.mapper

import com.example.core.model.User
import com.example.infrastructure.entity.UserJpa
import io.micronaut.context.annotation.Prototype

@Prototype
class UserJpaMapperImpl : UserJpaMapper {
    override fun toUser(userJpa: UserJpa): User {
        return User(
            name = userJpa.name,
            email = userJpa.email,
            document = userJpa.document,
            bithDate = userJpa.birthDate
        ).apply {
            id = userJpa.id
        }
    }

    override fun toUserJpaUnmanaged(user: User): UserJpa {
        with(user) {
            return UserJpa(
                name = name,
                email = email,
                document = document,
                birthDate = birthDate
            )
        }
    }

    override fun toUserJpaManaged(user: User): UserJpa {
        return UserJpa(
            name = user.name,
            email = user.email,
            document = user.document,
            birthDate = user.birthDate
        ).apply {
            id = user.id
        }
    }
}