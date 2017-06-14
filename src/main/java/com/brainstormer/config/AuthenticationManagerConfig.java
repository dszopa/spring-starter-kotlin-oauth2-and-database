package com.brainstormer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class AuthenticationManagerConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.jdbcAuthentication().dataSource(dataSource).withUser("dave")
                .password("secret").roles("USER", "ACTUATOR");
        // @formatter:on
    }
}
