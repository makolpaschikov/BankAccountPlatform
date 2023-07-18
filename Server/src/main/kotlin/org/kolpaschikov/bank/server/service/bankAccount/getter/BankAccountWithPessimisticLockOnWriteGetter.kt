package org.kolpaschikov.bank.server.service.bankAccount.getter

import org.kolpaschikov.bank.server.exception.NotFoundBankAccountException
import org.kolpaschikov.bank.server.repositroy.BankAccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankAccountWithPessimisticLockOnWriteGetter(
        bankAccountRepository: BankAccountRepository
) : AbstractBankAccountGetter(bankAccountRepository) {

    @Transactional
    override fun getBalance(id: Long): Long {
        return bankAccountRepository
                .getAllById(id)
                .orElseThrow { NotFoundBankAccountException(id) }
                .balance
    }
}