package org.kolpaschikov.bank.server.service.statisticLogger.scheduler

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.kolpaschikov.bank.server.service.statisticLogger.logger.StatisticRuntimeLogger
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.TimeUnit

@Configuration
@EnableScheduling
class StatisticLogSchedulerScheduler(private val statisticRuntimeLogger: StatisticRuntimeLogger) {
    @PostConstruct
    fun postConstruct() {
        statisticRuntimeLogger.writeStatisticToLog()
    }

    @PreDestroy
    fun preDestroy() {
        statisticRuntimeLogger.writeStatisticToLog()
    }

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    fun scheduleHistoryLogging() {
        statisticRuntimeLogger.writeStatisticToLog()
    }
}
