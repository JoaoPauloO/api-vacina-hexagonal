package com.example.core.port

import com.example.core.model.VaccineApplication

interface VaccineApplicationRequest {
    fun registerVaccineApplication(vaccineApplication: VaccineApplication): Long
}