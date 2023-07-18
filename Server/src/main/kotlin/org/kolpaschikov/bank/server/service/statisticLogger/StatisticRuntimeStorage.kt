package org.kolpaschikov.bank.server.service.statisticLogger

import java.util.stream.Collectors

class StatisticRuntimeStorage {
    companion object {
        private var STATISTIC_MAP = HashMap<String, Int>()

        fun getTotalRequestCount(): Int {
            return STATISTIC_MAP
                    .values
                    .stream()
                    .collect(Collectors.summingInt(Int::toInt))
        }

        fun getStatistic(): Set<Map.Entry<String, Int>> = STATISTIC_MAP.entries

        fun updateStatistic(methodName: String) {
            var methodCallCount = STATISTIC_MAP.getOrDefault(methodName, 0)
            STATISTIC_MAP[methodName] = ++methodCallCount
        }
    }
}