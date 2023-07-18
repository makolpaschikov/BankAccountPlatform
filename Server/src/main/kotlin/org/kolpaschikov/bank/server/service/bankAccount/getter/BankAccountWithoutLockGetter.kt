package org.kolpaschikov.bank.server.service.bankAccount.getter

import org.kolpaschikov.bank.server.exception.NotFoundBankAccountException
import org.kolpaschikov.bank.server.repositroy.BankAccountRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankAccountWithoutLockGetter(
        bankAccountRepository: BankAccountRepository
) : AbstractBankAccountGetter(bankAccountRepository) {

    @Transactional(noRollbackFor = [NotFoundBankAccountException::class])
    @Cacheable(value = ["balance"], key = "#id")
    override fun getBalance(id: Long): Long {
        return bankAccountRepository
                .findById(id)
                .orElseThrow { NotFoundBankAccountException(id) }
                .balance
    }
}