package com.example.entrypoint.rest.controller

import com.example.entrypoint.rest.dto.UserRequestDto
import com.example.entrypoint.rest.mapper.UserDtoMapper
import com.example.core.port.UserRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.net.URI
import javax.validation.Valid


@Controller("api/v1/user")
@Validated
class UserController(
    private val userRequestPort: UserRequest,
    private val mapper: UserDtoMapper
) {

    @Post
    fun registerUser(@Valid @Body request: UserRequestDto): HttpResponse<Any> {
        val user = mapper.toUser(request)
        val userId = userRequestPort.registerUser(user)
        val uri = URI.create("http://localhost/api/v1/user/${userId}")
        return HttpResponse.created(uri)
    }

    @Get("/{userId}")
    fun getUser(@PathVariable("userId") userId: Long): HttpResponse<Any> {
        val user = userRequestPort.findById(userId)
        val response = mapper.toUserResponseDto(user)
        return HttpResponse.ok(response)
    }
}