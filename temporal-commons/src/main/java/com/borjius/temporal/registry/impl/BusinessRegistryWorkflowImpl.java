package com.borjius.temporal.registry.impl;

import com.borjius.temporal.activities.*;
import com.borjius.temporal.registry.BusinessRegistryWorkflow;
import io.temporal.activity.ActivityCancellationType;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BusinessRegistryWorkflowImpl extends BaseWorkflowImpl implements BusinessRegistryWorkflow {

    private final Map<String, ActivityOptions> legalRatingActivityOptions = new HashMap<String, ActivityOptions>(){{
        put("CheckLegalRating",
                ActivityOptions.newBuilder().setCancellationType(ActivityCancellationType.ABANDON)
                        .setHeartbeatTimeout(Duration.ofSeconds(5)).build());
    }};

    private final AgreementDocumentSignedActivity agreementDocumentSigned = Workflow
            .newActivityStub(AgreementDocumentSignedActivity.class, defaultActivityOptions);

    private final ClientConfigurationActivity clientConfiguration = Workflow
            .newActivityStub(ClientConfigurationActivity.class, defaultActivityOptions);

    private final CountryBusinessActivity countryBusiness = Workflow
            .newActivityStub(CountryBusinessActivity.class, defaultActivityOptions);

    private final EmergencyNumberActivity emergencyNumber = Workflow
            .newActivityStub(EmergencyNumberActivity.class, defaultActivityOptions);

    private final LegalRatingActivity legalRating = Workflow
            .newActivityStub(LegalRatingActivity.class, defaultActivityOptions, legalRatingActivityOptions);

    @Override
    public void registry(UUID clientId, UUID phoneNumberId) {
        clientConfiguration.checkConfigurationAllowance(clientId, phoneNumberId);
        countryBusiness.checkClientInCountryAllowed(clientId, phoneNumberId);
        emergencyNumber.checkCountryRestrictions(phoneNumberId);
        agreementDocumentSigned.checkDocumentSigned(clientId, phoneNumberId);
        legalRating.checkLegalRating(clientId);
    }
}
