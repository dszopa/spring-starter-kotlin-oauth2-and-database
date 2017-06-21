package com.brainstormer.controller

import com.brainstormer.entity.User
import com.brainstormer.repository.UserRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@PreAuthorize("hasRole('ADMIN')")
class UserController (val repository:UserRepository) {

    @GetMapping("/users")
    fun findAll(): List<User>? = repository.findAll()
}