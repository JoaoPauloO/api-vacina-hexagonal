package com.example.core.model

import com.example.core.valueobject.UserDocument
import com.example.core.valueobject.UserEmail
import com.example.core.valueobject.UserName
import java.time.LocalDate

class User(
    private val _User_name: UserName,
    private val _User_email: UserEmail,
    private val _User_document: UserDocument,
    private val _birthDate: LocalDate
) {

    val name get() = _User_name.value
    val email get() = _User_email.value
    val document get() = _User_document.value
    val birthDate get() = _birthDate

    constructor(
        name: String,
        email: String,
        document: String,
        bithDate: LocalDate
    ): this(
        UserName(name),
        UserEmail(email),
        UserDocument(document),
        bithDate
    )

    var id: Long? = null
}