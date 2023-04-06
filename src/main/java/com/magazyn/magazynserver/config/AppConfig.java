package com.magazyn.magazynserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.magazyn.magazynserver.config.Constants.APP_PROPERTIES;

@Configuration
@PropertySource(APP_PROPERTIES)
@EnableJpaRepositories
public class AppConfig {
    
}
