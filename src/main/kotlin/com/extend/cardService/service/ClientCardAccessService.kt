package com.extend.cardService.service

import com.extend.cardService.model.Transactions
import com.extend.cardService.model.VirtualCard
import com.extend.cardService.model.VirtualCards
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class ClientCardAccessService(private val authenticationService: AuthenticationService) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ClientCardAccessService::class.java)
    }

    fun getClientCardAccess(): List<VirtualCard>? {
        val webClient: WebClient = WebClient.create()
        val token = authenticationService.getToken()

        val virtualCards = getVirtualCards(token, webClient)?.virtualCards
        virtualCards?.forEach() { virtualCard ->
            val transactions = getCardTransactionDetails(virtualCard.id, token, webClient)?.transactions
            if (transactions != null) {
                virtualCard.transactionDetails.addAll(transactions)
            }
        }
        return virtualCards
    }

    private fun getVirtualCards(token: String, webClient: WebClient): VirtualCards? {
        return webClient.get()
            .uri("https://api.paywithextend.com/virtualcards")
            .header("Accept", "application/vnd.paywithextend.v2021-03-12+json")
            .header("Authorization", "Bearer $token")
            .retrieve()
            .bodyToMono(VirtualCards::class.java)
            .block()
    }

    private fun getCardTransactionDetails(
        cardId: String,
        token: String,
        webClient: WebClient
    ): Transactions? {
        return webClient.get()
            .uri("https://api.paywithextend.com/virtualcards/$cardId/transactions")
            .header("Accept", "application/vnd.paywithextend.v2021-03-12+json")
            .header("Authorization", "Bearer $token")
            .retrieve()
            .bodyToMono(Transactions::class.java)
            .block()
    }
}
