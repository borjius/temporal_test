package com.borjius.temporal.worker.registry;

import com.borjius.temporal.activities.RegistryActivity;
import com.borjius.temporal.registry.impl.BusinessRegistryWorkflowImpl;
import com.borjius.temporal.registry.impl.PersonalRegistryWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistryWorker {

    private final Worker worker;

    @Autowired
    public RegistryWorker(final RegistryProperties properties, final RegistryActivity[] registryActivities) {
        final WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        final WorkflowClient client = WorkflowClient.newInstance(service);
        final WorkerFactory factory = WorkerFactory.newInstance(client);
        worker = factory.newWorker(properties.getQueue());
        worker.registerWorkflowImplementationTypes(BusinessRegistryWorkflowImpl.class,
                PersonalRegistryWorkflowImpl.class);

        worker.registerActivitiesImplementations(registryActivities);

        factory.start();
    }




}
