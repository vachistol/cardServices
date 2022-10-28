package com.extend.cardService.service

import com.extend.cardService.model.UserAuthentication
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

@Service
class AuthenticationService(
    @Value("\${card.client.username}") private val cardClientUsername: String,
    @Value("\${card.client.password}") private val cardClientPassword: String,
    ) {

    fun getToken(): String {
        val webClient: WebClient = WebClient.create()
        val body = "{\n" +
                "\"email\":\"$cardClientUsername\",\n" +
                "\"password\":\"$cardClientPassword\"\n" +
                "}"

        val userAuthentication = webClient.post()
            .uri("https://api.paywithextend.com/signin")
            .header("Accept", "application/vnd.paywithextend.v2021-03-12+json")
            .header("Content-Type", "application/json")
            .body(BodyInserters.fromValue(body))
            .retrieve()
            .bodyToMono(UserAuthentication::class.java)
            .block()

            return userAuthentication?.token ?:
                throw IllegalStateException("User Token does not exist for user $cardClientUsername")
    }
}
