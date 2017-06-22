package com.brainstormer.config.test

import org.h2.server.web.WebServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("test")
class TestWebConfig {

    @Bean
    fun h2ServletRegistration(): ServletRegistrationBean {
        var registrationBean: ServletRegistrationBean = ServletRegistrationBean(WebServlet());
        registrationBean.addUrlMappings("/console/*")
        return registrationBean
    }
}
