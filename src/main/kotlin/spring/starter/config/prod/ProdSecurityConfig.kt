package spring.starter.config.prod

import spring.starter.service.CustomUserDetailsService
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@Profile("prod")
@Configuration
@EnableWebSecurity
// This is needed to get authentication to work
// Not 100% sure why, might want to look into spring docs
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class ProdSecurityConfig(
        private var userDetailsService: CustomUserDetailsService,
        private var passwordEncoder: PasswordEncoder
) : WebSecurityConfigurerAdapter() {

    @Throws(exceptionClasses = Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity.csrf().disable()

        httpSecurity
                .authorizeRequests().antMatchers("/").permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin().disable()
    }

    @Throws(exceptionClasses = Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService)
    }

    @Bean
    @Throws(exceptionClasses = Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    // This is needed to have proper reading from the database for initial authentication
    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authenticationProvider: DaoAuthenticationProvider = DaoAuthenticationProvider()
        authenticationProvider.setUserDetailsService(userDetailsService)
        authenticationProvider.setPasswordEncoder(passwordEncoder)
        return authenticationProvider
    }
}