package com.example.core.valueobject

import com.example.core.exception.InvalidDocumentFormatException

class UserDocument(
    val value: String
) {

    init {
        if(this.value.length != 11 && this.value.length != 14) {
            throw InvalidDocumentFormatException()
        }
    }
}
