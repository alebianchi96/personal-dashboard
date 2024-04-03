package com.it.personaldashboard.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesStorage {
    
    @Value("${spring.application.name}")
    public String applicationName;

    @Value("${spring.datasource.url}")
    public String datasourceUrl;

}
