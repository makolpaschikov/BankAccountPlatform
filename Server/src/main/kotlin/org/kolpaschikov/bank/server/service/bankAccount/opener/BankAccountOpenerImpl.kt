package org.kolpaschikov.bank.server.service.bankAccount.opener

import org.kolpaschikov.bank.server.domain.entity.BankAccountEntity
import org.kolpaschikov.bank.server.exception.NotFoundBankAccountException
import org.kolpaschikov.bank.server.repositroy.BankAccountRepository
import org.kolpaschikov.bank.server.service.bankAccount.getter.AbstractBankAccountGetter
import org.kolpaschikov.bank.server.service.bankAccount.getter.BankAccountGetter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.annotation.CachePut
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankAccountOpenerImpl(
        @Qualifier("bankAccountWithoutLockGetter") private val bankAccountGetter: BankAccountGetter,
        private val bankAccountRepository: BankAccountRepository
) : BankAccountOpener {
    @Synchronized
    @Transactional
    @CachePut(value = ["balance"], key = "#id")
    override fun openBalance(id: Long): Long {
        return try {
            bankAccountGetter.getBalance(id)
        } catch (e: NotFoundBankAccountException) {
            val balance = BankAccountEntity(id)
            val saved = bankAccountRepository.save(balance)
            saved.balance
        }
    }
}