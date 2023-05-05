package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.LegalRatingActivity;
import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.util.SimulationUtil;

import java.util.UUID;

public class LegalRatingActivityImpl implements LegalRatingActivity {
    @Override
    public void checkLegalRating(final UUID clientId) {
        if (ClientService.CLIENT_WITH_BAD_LEGAL_RATING.equals(clientId)) {
            throw new RuntimeException("Legal rating error");
        }
        SimulationUtil.forceError(2);
    }
}
