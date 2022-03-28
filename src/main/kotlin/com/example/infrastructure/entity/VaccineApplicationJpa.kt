package com.example.infrastructure.entity

import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.GenerationType.*

@Entity
@Table(name = "vaccine_applications")
class VaccineApplicationJpa(
    @field:Column(nullable = false)
    val vaccineName: String,

    @field:ManyToOne(cascade = [MERGE])
    val userJpa: UserJpa
) {

    @field:Id
    @field:GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}