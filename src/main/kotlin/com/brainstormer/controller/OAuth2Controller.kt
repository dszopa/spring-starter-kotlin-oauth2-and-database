package com.brainstormer.controller

import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@PreAuthorize("isFullyAuthenticated()")
class OAuth2Controller (
        val authorizationServerTokenServices:AuthorizationServerTokenServices,
        val consumerTokenServices:ConsumerTokenServices
) {
    @GetMapping("/oauth/revoke-token")
    @ResponseStatus(HttpStatus.OK)
    fun logout(principal: Principal) {
        val accessToken : OAuth2AccessToken = authorizationServerTokenServices.getAccessToken(principal as OAuth2Authentication);
        consumerTokenServices.revokeToken(accessToken.value);
    }
}