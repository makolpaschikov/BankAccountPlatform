package org.kolpaschikov.bank.server.service.statisticLogger.logger

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.kolpaschikov.bank.server.service.statisticLogger.StatisticRuntimeStorage
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.locks.Lock

@Service
class StatisticRuntimeLoggerImpl(private val statisticLock: Lock) : StatisticRuntimeLogger {

    var logger: Logger = LogManager.getLogger(StatisticRuntimeLoggerImpl::class.java)

    override fun writeStatisticToLog() {
        synchronized(statisticLock) {
            val mainStatistic = String.format(
                    "%s | Total Request Count: %d. ",
                    getCurrentDateTime(),
                    StatisticRuntimeStorage.getTotalRequestCount()
            )

            val logBuilder = StringBuilder()
            logBuilder.append(mainStatistic)

            for (statistic in StatisticRuntimeStorage.getStatistic()) {
                val methodStatistic = String.format("Method '%s': %d. ", statistic.key, statistic.value)
                logBuilder.append(methodStatistic)
            }

            logger.info(logBuilder.toString())
        }
    }

    private fun getCurrentDateTime(): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss")
        val now = LocalDateTime.now()
        return dateTimeFormatter.format(now)
    }

}
