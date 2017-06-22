package com.brainstormer.service

import com.brainstormer.entity.User
import com.brainstormer.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
class CustomUserDetailsService (
        private val userRepository: UserRepository
) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByLogin(username) ?: throw UsernameNotFoundException("User " + username + "s does not exist!")
        return UserRepositoryUserDetails(user)
    }

    internal class UserRepositoryUserDetails  (val user: User) : User(user), UserDetails, Serializable {

        override fun getAuthorities(): Collection<GrantedAuthority> {
            return roles
        }

        override fun getUsername(): String? {
            return login
        }

        override fun isAccountNonExpired(): Boolean {
            return true
        }

        override fun isAccountNonLocked(): Boolean {
            return true
        }

        override fun isCredentialsNonExpired(): Boolean {
            return true
        }

        override fun isEnabled(): Boolean {
            return true
        }

        companion object {
            private const val serialVersionUID = 1L
        }
    }
}
