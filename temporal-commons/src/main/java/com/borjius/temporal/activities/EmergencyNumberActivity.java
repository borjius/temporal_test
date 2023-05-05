package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface EmergencyNumberActivity extends RegistryActivity {

    @ActivityMethod
    void checkCountryRestrictions(UUID phoneNumberId);
}
