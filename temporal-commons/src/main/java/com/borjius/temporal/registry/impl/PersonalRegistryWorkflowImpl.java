package com.borjius.temporal.registry.impl;

import com.borjius.temporal.activities.AgreementDocumentSignedActivity;
import com.borjius.temporal.activities.ClientConfigurationActivity;
import com.borjius.temporal.activities.LegalRatingActivity;
import com.borjius.temporal.activities.PassportActivity;
import com.borjius.temporal.registry.PersonalRegistryWorkflow;
import io.temporal.workflow.Workflow;

import java.util.UUID;

public class PersonalRegistryWorkflowImpl extends BaseWorkflowImpl implements PersonalRegistryWorkflow {

    private final PassportActivity passport = Workflow
            .newActivityStub(PassportActivity.class, defaultActivityOptions);
    private final ClientConfigurationActivity clientConfiguration = Workflow
            .newActivityStub(ClientConfigurationActivity.class, defaultActivityOptions);

    private final AgreementDocumentSignedActivity agreementDocumentSigned = Workflow
            .newActivityStub(AgreementDocumentSignedActivity.class, defaultActivityOptions);

    private final LegalRatingActivity legalRating = Workflow
            .newActivityStub(LegalRatingActivity.class, defaultActivityOptions);

    @Override
    public void registry(UUID clientId, UUID phoneNumberId) {
        clientConfiguration.checkConfigurationAllowance(clientId, phoneNumberId);
        passport.checkExistingPassport(clientId);
        agreementDocumentSigned.checkDocumentSigned(clientId, phoneNumberId);
        legalRating.checkLegalRating(clientId);
    }
}
