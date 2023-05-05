package com.borjius.temporal.worker.registry;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("registry")
@Getter
@Setter
public class RegistryProperties {

    private String queue;
}
