package org.kolpaschikov.bank.server.service.bankAccount

interface BankAccountControllerFacade {
    /**
     * Получение баланса
     *
     * @param id идентификатор банковского счёта
     * @return сумма денег на банковском счёте
     */
    fun getBalance(id: Long): Long

    /**
     * Открывает новый банковский счет
     *
     * @param id идентификатор банковского счёта
     */
    fun openBalance(id: Long)

    /**
     * Изменение баланса на определённое значение
     *
     * @param id     идентификатор банковского счёта
     * @param amount сумма денег, которую нужно добавить к банковскому счёту
     */
    fun changeBalance(id: Long, amount: Long)
}