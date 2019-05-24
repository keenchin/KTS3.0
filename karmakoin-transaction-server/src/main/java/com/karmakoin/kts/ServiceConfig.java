package com.karmakoin.kts;

import com.karmakoin.kts.service.CardService;
import com.karmakoin.kts.service.ExchangeRateService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/v3")
public class ServiceConfig extends ResourceConfig {
    public ServiceConfig() {
        register(CardService.class);
        register(ExchangeRateService.class);
        register(Formatter.class);
    }
}
