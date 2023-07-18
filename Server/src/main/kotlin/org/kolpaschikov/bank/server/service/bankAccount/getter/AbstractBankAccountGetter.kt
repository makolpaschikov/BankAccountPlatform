package org.kolpaschikov.bank.server.service.bankAccount.getter

import org.kolpaschikov.bank.server.repositroy.BankAccountRepository

abstract class AbstractBankAccountGetter(protected val bankAccountRepository: BankAccountRepository) : BankAccountGetter