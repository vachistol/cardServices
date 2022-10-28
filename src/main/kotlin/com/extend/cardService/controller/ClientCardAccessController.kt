package com.extend.cardService.controller

import com.extend.cardService.model.VirtualCard
import com.extend.cardService.service.ClientCardAccessService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
class ClientCardAccessController(
    private val clientCardAccessService: ClientCardAccessService
) {

    @GetMapping("/cardAccess")
    fun getClientCardAccess(): List<VirtualCard>? {
        return clientCardAccessService.getClientCardAccess()
    }
}
