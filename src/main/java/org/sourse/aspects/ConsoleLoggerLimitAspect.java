package org.sourse.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.sourse.beans.Event;
import org.sourse.logger.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConsoleLoggerLimitAspect {

    private final int maxCount;

    private final EventLogger otherLogger;

    private int currentCount = 0;

    @Autowired
    public ConsoleLoggerLimitAspect(
            @Value("${countConsoleLogToPrint}") int maxCount,
            @Qualifier("fileLogger") EventLogger otherLogger) {
        this.maxCount = maxCount;
        this.otherLogger = otherLogger;
    }

    @Around("execution(* *.logEvent(org.sourse.beans.Event)) "
            + "&& within(org.sourse.logger.ConsoleEventLogger) "
            + "&& args(evt)")
    public void aroundLogEvent(ProceedingJoinPoint jp, Event evt) throws Throwable {
        if (currentCount < maxCount) {
            currentCount++;

            jp.proceed(new Object[] { evt });
        } else {
            otherLogger.logEvent(evt);
        }
    }

}