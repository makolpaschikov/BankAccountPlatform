package org.kolpaschikov.bank.server.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.Valid
import org.kolpaschikov.bank.server.domain.dto.BankAccountDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface BankAccountAPI {

    /**
     * Получение баланса
     *
     * @param id идентификатор банковского счёта
     * @return сумма денег на банковском счёте
     */
    @GetMapping(path = ["{id}"])
    @Operation(summary = "Получение баланса счета по идентификатору")
    fun getBalance(@PathVariable @Parameter(description = "Идентификатор счета") id: Long): ResponseEntity<Long>

    /**
     * Открытие нового банковского счета
     *
     * @param id идентификатор банковского счёта
     */
    @PostMapping(path = ["{id}"])
    @Operation(summary = "Открытие нового счета")
    fun openBalance(@PathVariable @Parameter(description = "Идентификатор счета") id: Long): ResponseEntity<Void>

    /**
     * Изменение баланса счета на определённое значение
     *
     * @param bankAccountDto DTO с информацией о счете
     */
    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @Operation(summary = "Изменение баланса на счете")
    fun changeBalance(@RequestBody @Valid bankAccountDto: BankAccountDto): ResponseEntity<Void>
}