package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.AgreementDocumentSignedActivity;
import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.util.SimulationUtil;

import java.util.UUID;

public class AgreementDocumentSignedActivityImpl implements AgreementDocumentSignedActivity {

    @Override
    public void checkDocumentSigned(final UUID clientId, final UUID phoneNumberId) {
        if (ClientService.CLIENT_WITHOUT_AGREEMENT_SIGNATURE.equals(clientId)) {
            throw new RuntimeException("Client without configuration allowed");
        }
        SimulationUtil.forceError(3);
    }
}
