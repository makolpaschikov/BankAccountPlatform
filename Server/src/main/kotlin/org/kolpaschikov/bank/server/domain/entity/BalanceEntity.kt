package org.kolpaschikov.bank.server.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "balance")
data class BalanceEntity(
        @Id
        @Column(name = "id", nullable = false)
        private var id: Long? = null,

        @Column(name = "amount", nullable = false)
        private var amount: Long? = null
)