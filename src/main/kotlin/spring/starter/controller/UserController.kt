package spring.starter.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import spring.starter.entity.User
import spring.starter.repository.UserRepository

@RestController
@PreAuthorize("hasRole('ADMIN')")
class UserController (
        private val repository: UserRepository
) {

    @GetMapping("/users")
    fun findAll(): List<User>? = repository.findAll()
}