package org.kolpaschikov.bank.server.aop.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.kolpaschikov.bank.server.service.statisticLogger.StatisticRuntimeStorage
import org.springframework.stereotype.Service
import java.util.concurrent.locks.Lock

@Aspect
@Service
class StatisticCollectableAspect(private val statisticLock: Lock) {

    @Before("@annotation(org.kolpaschikov.bank.server.aop.annotation.StatisticCollectable)")
    fun beforeAdvice(joinPoint: JoinPoint) {
        synchronized(statisticLock) {
            val signature = joinPoint.signature
            if (signature is MethodSignature) {
                val methodName: String = signature.method.name
                StatisticRuntimeStorage.updateStatistic(methodName)
            }
        }
    }

}