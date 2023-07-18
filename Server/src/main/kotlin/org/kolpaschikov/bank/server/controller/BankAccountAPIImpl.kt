package org.kolpaschikov.bank.server.controller

import org.kolpaschikov.bank.server.domain.dto.BankAccountDto
import org.kolpaschikov.bank.server.service.bankAccount.BankAccountControllerFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bank-Account")
class BankAccountAPIImpl(
        private val bankAccountControllerFacade: BankAccountControllerFacade
) : BankAccountAPI {

    override fun getBalance(id: Long): ResponseEntity<Long> {
        return ResponseEntity.ok(bankAccountControllerFacade.getBalance(id))
    }

    override fun openBalance(id: Long): ResponseEntity<Void> {
        bankAccountControllerFacade.openBalance(id)
        return ResponseEntity.ok().build()
    }

    override fun changeBalance(bankAccountDto: BankAccountDto): ResponseEntity<Void> {
        bankAccountControllerFacade.changeBalance(bankAccountDto.id, bankAccountDto.amount)
        return ResponseEntity.ok().build()
    }
}