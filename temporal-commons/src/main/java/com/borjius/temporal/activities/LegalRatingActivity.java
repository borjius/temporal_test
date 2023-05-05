package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface LegalRatingActivity extends RegistryActivity {

    @ActivityMethod
    void checkLegalRating(UUID clientId);
}
