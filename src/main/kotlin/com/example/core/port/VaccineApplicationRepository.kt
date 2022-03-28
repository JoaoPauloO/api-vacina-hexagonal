package com.example.core.port

import com.example.core.model.VaccineApplication

interface VaccineApplicationRepository {
    fun save(vacc: VaccineApplication): VaccineApplication
}