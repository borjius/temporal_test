package com.borjius.temporal.registry;

import com.borjius.temporal.activities.*;
import com.borjius.temporal.activities.impl.*;
import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.phonenumber.PhoneNumberService;
import com.borjius.temporal.registry.impl.BusinessRegistryWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BusinessRegistryWorkflowTest {

    private static final String TEST_QUEUE = "test_queue";

    private final AgreementDocumentSignedActivity agreementDocumentSignedActivity =
            mock(AgreementDocumentSignedActivityImpl.class);
    private final ClientConfigurationActivity clientConfigurationActivity = mock(ClientConfigurationActivityImpl.class);
    private final CountryBusinessActivity countryBusinessActivity = mock(CountryBusinessActivityImpl.class);
    private final EmergencyNumberActivity emergencyNumberActivity = mock(EmergencyNumberActivityImpl.class);
    private final LegalRatingActivity legalRatingActivity = mock(LegalRatingActivityImpl.class);
    private final PassportActivity passportActivity = mock(PassportActivityImpl.class);

    private TestWorkflowEnvironment testEnv;
    private Worker worker;
    private WorkflowClient workflowClient;
    private BusinessRegistryWorkflow sut;



    @BeforeEach
    void setUp() {
        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker(TEST_QUEUE);
        worker.registerWorkflowImplementationTypes(BusinessRegistryWorkflowImpl.class);
        workflowClient = testEnv.getWorkflowClient();
        worker.registerActivitiesImplementations(agreementDocumentSignedActivity, clientConfigurationActivity,
                countryBusinessActivity, emergencyNumberActivity, legalRatingActivity, passportActivity);
        testEnv.start();

        final WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TEST_QUEUE)
                .build();

        sut = workflowClient.newWorkflowStub(BusinessRegistryWorkflow.class, options);
    }

    @AfterEach
    void tearDown() {
        testEnv.close();
    }

    @Test
    void businessRegistration_ShouldReturnOk_WhenInputIsOk() {
        sut.registry(ClientService.CLIENT_OK, PhoneNumberService.PHONE_EU);

        verify(clientConfigurationActivity)
                .checkConfigurationAllowance(eq(ClientService.CLIENT_OK), eq(PhoneNumberService.PHONE_EU));
        verify(countryBusinessActivity)
                .checkClientInCountryAllowed(eq(ClientService.CLIENT_OK), eq(PhoneNumberService.PHONE_EU));
        verify(emergencyNumberActivity).checkCountryRestrictions(eq(PhoneNumberService.PHONE_EU));
        verify(agreementDocumentSignedActivity)
                .checkDocumentSigned(eq(ClientService.CLIENT_OK), eq(PhoneNumberService.PHONE_EU));
        verify(legalRatingActivity).checkLegalRating(eq(ClientService.CLIENT_OK));
    }
}
