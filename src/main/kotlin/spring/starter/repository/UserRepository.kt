package spring.starter.repository

import org.springframework.data.jpa.repository.JpaRepository
import spring.starter.entity.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByLogin(login: String): User?
}