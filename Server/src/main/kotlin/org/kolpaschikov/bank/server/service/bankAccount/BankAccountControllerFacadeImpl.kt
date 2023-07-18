package org.kolpaschikov.bank.server.service.bankAccount

import org.kolpaschikov.bank.server.service.bankAccount.changer.BankAccountChanger
import org.kolpaschikov.bank.server.service.bankAccount.getter.BankAccountGetter
import org.kolpaschikov.bank.server.service.bankAccount.opener.BankAccountOpener
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankAccountControllerFacadeImpl(
        @Qualifier("bankAccountWithPessimisticLockOnWriteGetter") private val bankAccountGetter: BankAccountGetter,
        private val bankAccountOpener: BankAccountOpener,
        private val bankAccountChanger: BankAccountChanger
) : BankAccountControllerFacade {

    override fun getBalance(id: Long): Long {
        return bankAccountGetter.getBalance(id)
    }

    override fun openBalance(id: Long) {
        bankAccountOpener.openBalance(id)
    }

    override fun changeBalance(id: Long, amount: Long) {
        bankAccountChanger.changeBalance(id, amount)
    }
}