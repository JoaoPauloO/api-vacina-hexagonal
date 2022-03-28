package com.example.core.model

import com.example.core.valueobject.VaccineName

class VaccineApplication(
    private val _vaccineName: VaccineName,
    val user: User
) {

    constructor(vaccineName: String, user: User) : this(VaccineName(vaccineName), user)

    var id: Long? = null

    val vaccineName get() = _vaccineName.value
    val userEmail get() = user.email
}
