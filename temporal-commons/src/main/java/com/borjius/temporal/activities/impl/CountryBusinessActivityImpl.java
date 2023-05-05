package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.CountryBusinessActivity;
import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.phonenumber.PhoneNumberService;
import com.borjius.temporal.util.SimulationUtil;

import java.util.UUID;

public class CountryBusinessActivityImpl implements CountryBusinessActivity {
    @Override
    public void checkClientInCountryAllowed(final UUID clientId, final UUID phoneNumberId) {
        if (PhoneNumberService.PHONE_US.equals(phoneNumberId)
                && ClientService.CLIENT_WITH_NO_BUSINESS_ACTIVITY_IN_US == clientId) {
            throw new RuntimeException("Client cannot operate in country");
        }
        SimulationUtil.forceError(4);
    }
}
