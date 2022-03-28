package com.example.infrastructure.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class UserJpa(
    @field:Column(nullable = false)
    var name: String,

    @field:Column(unique = true, nullable = false)
    val email: String,

    @field:Column(unique = true, nullable = false)
    val document: String,

    @field:Column(nullable = false)
    val birthDate: LocalDate
) {

    @field:Id
    @field:GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}