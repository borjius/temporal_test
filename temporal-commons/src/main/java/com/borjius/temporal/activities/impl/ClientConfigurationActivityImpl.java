package com.borjius.temporal.activities.impl;

import com.borjius.temporal.activities.ClientConfigurationActivity;
import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.util.SimulationUtil;

import java.util.UUID;

public class ClientConfigurationActivityImpl implements ClientConfigurationActivity {
    @Override
    public void checkConfigurationAllowance(final UUID clientId, final UUID phoneNumberId) {
        if (ClientService.CLIENT_WITHOUT_CONFIGURATION.equals(clientId)) {
            throw new RuntimeException("Client without configuration allowed");
        }
        SimulationUtil.forceError(4);
    }
}
