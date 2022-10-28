package com.extend.cardService.model

import java.time.Instant

data class CardTransaction(
    val merchantName: String?,
    val mccDescription: String?,
    val mccGroup: String?,
    val authBillingAmountCents: Long,
    val authBillingCurrency: String,
    val authedAt: Instant,
    val type: String?,
    val status: String?
    )
