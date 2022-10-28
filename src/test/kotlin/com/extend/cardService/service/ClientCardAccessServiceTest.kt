package com.extend.cardService.service

import com.extend.cardService.model.CardTransaction
import com.extend.cardService.model.VirtualCard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.time.Instant

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClientCardAccessServiceTest {

    private val authenticationService: AuthenticationService = AuthenticationService("y", "x")
    private val clientCardAccessService: ClientCardAccessService = ClientCardAccessService(authenticationService)

    //@Test
    fun `get user card access`() {
        val virtualCards = clientCardAccessService.getClientCardAccess()
        assertThat(virtualCards).isNotNull
        virtualCards?.apply {
             assertThat(virtualCards)
                 .hasSize(1)
                 .containsExactlyInAnyOrder(
                     VirtualCard(
                         "vc_ABcURvCY3yl9cmHK27JVI6",
                         "Victoria’s take home assignment",
                         Instant.parse("2023-08-01T00:00:00.00Z"),
                         "USD",
                         5000L,
                         177L,
                         mutableListOf(
                             CardTransaction(
                                 "HANNA ANDERSSON HQ     PORTLAND      OR",
                                 "CHILDRENS AND INFANTS WEAR STORES",
                                 "RETAIL",
                                 4227L,
                                 "USD",
                                 Instant.parse("2022-10-25T20:26:31.00Z"),
                                 "DEBIT",
                                 "PENDING"
                             )
                         )
                     )
                 )
        }
    }
}
