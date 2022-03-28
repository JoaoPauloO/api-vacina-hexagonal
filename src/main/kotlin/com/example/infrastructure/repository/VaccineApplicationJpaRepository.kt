package com.example.infrastructure.repository

import com.example.infrastructure.entity.VaccineApplicationJpa
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface VaccineApplicationJpaRepository : JpaRepository<VaccineApplicationJpa, Long>