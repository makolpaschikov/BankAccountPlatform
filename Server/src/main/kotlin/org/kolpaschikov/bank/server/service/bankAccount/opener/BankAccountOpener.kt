package org.kolpaschikov.bank.server.service.bankAccount.opener

interface BankAccountOpener {
    /**
     * Открывает новый банковский счет
     *
     * @param id идентификатор банковского счёта
     */
    fun openBalance(id: Long): Long
}