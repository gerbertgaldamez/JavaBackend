package com.enyoi.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvsFacadeImpl implements EnvsFacade {

    @Value("${app.envs.client.host}") //Esto quiero que lo inyecte como una variable de entorno
    private String host; //No lo podemos mockear


    @Override
    public String getClientHostEnv() {
        return host;
    }

    @Override
    public String getClientPath() {
        return "api/v1/client/";
    }
}