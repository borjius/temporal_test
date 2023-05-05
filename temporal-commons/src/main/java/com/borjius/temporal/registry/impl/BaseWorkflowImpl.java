package com.borjius.temporal.registry.impl;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;

import java.time.Duration;

public class BaseWorkflowImpl {

    protected final RetryOptions retryOptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumAttempts(500)
            .build();

    protected final ActivityOptions defaultActivityOptions = ActivityOptions.newBuilder()
            // Timeout options specify when to automatically timeout Activities if the process is taking too long.
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            // Optionally provide customized RetryOptions.
            // Temporal retries failures by default, this is simply an example.
            .setRetryOptions(retryOptions)
            .build();


}
