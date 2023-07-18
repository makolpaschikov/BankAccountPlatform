package org.kolpaschikov.bank.server.service.bankAccount.changer

interface BankAccountChanger {
    /**
     * Изменение баланса на определённое значение
     *
     * @param id     идентификатор банковского счёта
     * @param amount сумма денег, которую нужно добавить к банковскому счёту
     */
    fun changeBalance(id: Long, amount: Long): Long
}