package org.kolpaschikov.bank.server.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class TimeZoneConfig {

    @PostConstruct
    public void setTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
    }


}
