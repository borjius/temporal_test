package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface ClientConfigurationActivity extends RegistryActivity {

    @ActivityMethod
    void checkConfigurationAllowance(UUID clientId, UUID phoneNumberId);
}
