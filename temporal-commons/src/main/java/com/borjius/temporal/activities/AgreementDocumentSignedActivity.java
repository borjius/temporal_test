package com.borjius.temporal.activities;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.UUID;

@ActivityInterface
public interface AgreementDocumentSignedActivity extends RegistryActivity {

    @ActivityMethod
    void checkDocumentSigned(UUID clientId, UUID phoneNumberId);
}
