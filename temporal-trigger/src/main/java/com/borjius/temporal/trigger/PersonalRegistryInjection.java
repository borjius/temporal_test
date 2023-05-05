package com.borjius.temporal.trigger;

import com.borjius.temporal.client.ClientService;
import com.borjius.temporal.phonenumber.PhoneNumberService;
import com.borjius.temporal.registry.PersonalRegistryWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import static com.borjius.temporal.trigger.RegistryHelper.*;

public class PersonalRegistryInjection {

    public static void main(String[] args) {
        final WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        final WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(QUEUE_NAME)
                .build();
        final WorkflowClient client = WorkflowClient.newInstance(service);

        execute(client, ClientService.CLIENT_OK, PhoneNumberService.PHONE_OK, PersonalRegistryWorkflow.class, options);
        execute(client, ClientService.CLIENT_WITHOUT_CONFIGURATION, PhoneNumberService.PHONE_OK,
                PersonalRegistryWorkflow.class, options);
        execute(client, ClientService.CLIENT_WITHOUT_PASSPORT, PhoneNumberService.PHONE_OK,
                PersonalRegistryWorkflow.class, options);
        execute(client, ClientService.CLIENT_WITHOUT_AGREEMENT_SIGNATURE, PhoneNumberService.PHONE_OK,
                PersonalRegistryWorkflow.class, options);
        execute(client, ClientService.CLIENT_WITH_BAD_LEGAL_RATING, PhoneNumberService.PHONE_OK,
                PersonalRegistryWorkflow.class, options);

        System.exit(0);
    }
}
