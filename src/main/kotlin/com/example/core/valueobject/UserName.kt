package com.example.core.valueobject

import com.example.core.exception.NameBlankException

class UserName(
    val value: String
) {
    init {
        if (this.value.isBlank()) {
            throw NameBlankException()
        }
    }
}