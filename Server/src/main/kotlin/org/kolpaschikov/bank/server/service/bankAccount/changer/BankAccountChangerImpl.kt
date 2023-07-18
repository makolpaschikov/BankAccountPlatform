package org.kolpaschikov.bank.server.service.bankAccount.changer

import org.kolpaschikov.bank.server.domain.entity.BankAccountEntity
import org.kolpaschikov.bank.server.repositroy.BankAccountRepository
import org.kolpaschikov.bank.server.service.bankAccount.getter.BankAccountGetter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.annotation.CachePut
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BankAccountChangerImpl(
        @Qualifier("bankAccountWithPessimisticLockOnWriteGetter") private val bankAccountGetter: BankAccountGetter,
        private val bankAccountRepository: BankAccountRepository
) : BankAccountChanger {

    @Transactional
    @CachePut(value = ["balance"], key = "#id")
    override fun changeBalance(id: Long, amount: Long): Long {
        val oldBalance: Long = bankAccountGetter.getBalance(id)
        val newBalance = oldBalance + amount
        val balance = BankAccountEntity(id, newBalance)

        val saved = bankAccountRepository.save(balance)
        return saved.balance
    }
}