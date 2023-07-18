package org.kolpaschikov.bank.server.service.statisticLogger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

@Configuration
class StatisticLock {
    @get:Bean
    val statisticLock: Lock
        get() = ReentrantLock()
}
