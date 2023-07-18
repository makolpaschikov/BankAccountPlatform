package org.kolpaschikov.bank.server.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bank_account")
data class BankAccountEntity(
        @Id
        @Column(name = "id", nullable = false)
        var id: Long,

        @Column(name = "balance", nullable = false)
        var balance: Long = 0
)