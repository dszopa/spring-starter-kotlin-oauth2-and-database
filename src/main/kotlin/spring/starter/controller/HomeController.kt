package spring.starter.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    fun home() = "home"

    @PreAuthorize("permitAll()")
    @GetMapping("/remember")
    fun remember() = "remember"
}