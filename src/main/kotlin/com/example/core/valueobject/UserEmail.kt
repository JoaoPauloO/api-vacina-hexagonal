package com.example.core.valueobject

import com.example.core.exception.InvalidEmailException
import com.example.core.shared.REGEX_FOR_EMAIL
import java.util.regex.Pattern

class UserEmail(
    val value: String
) {
    init {
        val isValid = Pattern.compile(REGEX_FOR_EMAIL).matcher(this.value).matches()
        if(!isValid) {
            throw InvalidEmailException()
        }
    }
}
