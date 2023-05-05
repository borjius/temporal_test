package com.borjius.temporal.worker.registry;

import com.borjius.temporal.activities.*;
import com.borjius.temporal.activities.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistryWorkerConfig {

    @Bean
    public RegistryActivity[] createRegistryActivities() {
        return new RegistryActivity[]{
                new AgreementDocumentSignedActivityImpl(),
                new ClientConfigurationActivityImpl(),
                new CountryBusinessActivityImpl(),
                new EmergencyNumberActivityImpl(),
                new LegalRatingActivityImpl(),
                new PassportActivityImpl()
        };
    }

}
