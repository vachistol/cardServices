package com.extend.cardService.model

import java.time.Instant

data class VirtualCard(
    val id: String,
    val displayName: String,
    val expires: Instant,
    val currency: String,
    val limitCents: Long,
    val balanceCents: Long,
    val transactionDetails: MutableList<CardTransaction> = mutableListOf()
)
