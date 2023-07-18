package org.kolpaschikov.bank.server.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundBankAccountException(bankAccountId: Long)
    : RuntimeException("Bank Account with ID=$bankAccountId Not Founded")