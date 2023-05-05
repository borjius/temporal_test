package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface PassportActivity extends RegistryActivity {

    @ActivityMethod
    void checkExistingPassport(UUID clientId);
}
