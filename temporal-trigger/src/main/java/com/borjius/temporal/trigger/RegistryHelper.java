package com.borjius.temporal.trigger;

import com.borjius.temporal.registry.BusinessRegistryWorkflow;
import com.borjius.temporal.registry.RegistryWorkflow;
import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.util.UUID;

public class RegistryHelper {

    public static final String QUEUE_NAME = "registry_queue";

    public static <T extends RegistryWorkflow> void execute(final WorkflowClient client,
                                                            final UUID clientId,
                                                            final UUID phoneNumberId,
                                                            final Class<T> registryWorkflowClass,
                                                            final WorkflowOptions options) {
        final T workflow = client.newWorkflowStub(registryWorkflowClass, options);
        final WorkflowExecution we = WorkflowClient.start(workflow::registry, clientId, phoneNumberId);
        System.out.printf("\nRegistry is processing client %s and phonenumber %s\n", clientId, phoneNumberId);
        System.out.printf("\nWorkflowID: %s RunID: %s", we.getWorkflowId(), we.getRunId());
    }
}
