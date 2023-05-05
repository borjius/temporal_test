package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.EmergencyNumberActivity;
import com.borjius.temporal.phonenumber.PhoneNumberService;

import java.util.UUID;

public class EmergencyNumberActivityImpl implements EmergencyNumberActivity {

    @Override
    public void checkCountryRestrictions(final UUID phoneNumberId) {
        if (PhoneNumberService.PHONE_EMERGENCY_WRONG.equals(phoneNumberId)) {
            throw new RuntimeException("Emergency number error");
        }
    }
}
