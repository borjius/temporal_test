package com.borjius.temporal.client;

import io.temporal.activity.ActivityInterface;

import java.util.UUID;

public class ClientService {

    public static final UUID CLIENT_WITHOUT_PASSPORT = UUID.fromString("35d92584-a158-46a1-9dbd-2427f247cf66");
    public static final UUID CLIENT_WITHOUT_AGREEMENT_SIGNATURE = UUID.fromString("a41dee60-a2ab-4513-a99d-966129a1493c");
    public static final UUID CLIENT_WITHOUT_CONFIGURATION = UUID.fromString("1b0c7a87-a5b3-4f41-93fa-6b5b1123d45d");
    public static final UUID CLIENT_WITH_BAD_LEGAL_RATING = UUID.fromString("bffa60b1-f465-487b-96d5-0b6337f34015");
    public static final UUID CLIENT_OK = UUID.fromString("d9a38963-2728-4ca6-b08e-04b280df691a");
    public static final UUID CLIENT_WITH_NO_BUSINESS_ACTIVITY_IN_US = UUID.fromString("9905be0e-a81a-4207-8fc3-bf188a5f7cf5");


}
