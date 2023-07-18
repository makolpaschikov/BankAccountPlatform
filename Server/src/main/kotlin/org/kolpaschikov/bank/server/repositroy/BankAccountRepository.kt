package org.kolpaschikov.bank.server.repositroy

import jakarta.persistence.LockModeType
import org.kolpaschikov.bank.server.domain.entity.BankAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import java.util.*

interface BankAccountRepository : JpaRepository<BankAccountEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun getAllById(id: Long?): Optional<BankAccountEntity>

}