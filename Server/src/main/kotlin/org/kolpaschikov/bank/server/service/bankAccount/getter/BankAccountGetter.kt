package org.kolpaschikov.bank.server.service.bankAccount.getter

interface BankAccountGetter {
    /**
     * Получение баланса
     *
     * @param id идентификатор банковского счёта
     * @return сумма денег на банковском счёте
     */
    fun getBalance(id: Long): Long
}