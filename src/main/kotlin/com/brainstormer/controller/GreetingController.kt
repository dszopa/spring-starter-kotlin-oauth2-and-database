package com.brainstormer.controller

import com.brainstormer.entity.User
import com.brainstormer.model.Greeting
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@PreAuthorize("hasRole('ADMIN')")
class  GreetingController {

    private var counter: AtomicLong = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@AuthenticationPrincipal user: User): Greeting{
        return Greeting(counter.incrementAndGet(), "Hello, ${user.name}!")
    }
}
