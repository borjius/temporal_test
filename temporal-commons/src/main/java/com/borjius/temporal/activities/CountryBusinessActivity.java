package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface CountryBusinessActivity extends RegistryActivity {

    @ActivityMethod
    void checkClientInCountryAllowed(UUID clientId, UUID phoneNumberId);
}
