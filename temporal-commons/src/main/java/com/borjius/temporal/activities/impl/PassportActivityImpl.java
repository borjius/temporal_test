package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.PassportActivity;
import com.borjius.temporal.client.ClientService;

import java.util.UUID;

public class PassportActivityImpl implements PassportActivity {

    @Override
    public void checkExistingPassport(UUID clientId) {
        if (ClientService.CLIENT_WITHOUT_PASSPORT.equals(clientId)) {
            throw new RuntimeException("Passport not found");
        }
    }
}
