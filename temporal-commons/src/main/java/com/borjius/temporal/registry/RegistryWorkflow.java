package com.borjius.temporal.registry;

import io.temporal.workflow.WorkflowMethod;

import java.util.UUID;

public interface RegistryWorkflow {

    @WorkflowMethod
    void registry(UUID clientId, UUID phoneNumberId);
}
