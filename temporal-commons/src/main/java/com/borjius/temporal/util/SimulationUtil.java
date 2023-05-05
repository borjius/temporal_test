package com.borjius.temporal.util;

import java.util.Random;

public class SimulationUtil {

    private static final Random random = new Random();

    public static void forceError(final int frequency) {
        if (random.nextInt(frequency) == 1) {
            throw new RuntimeException("Simulated Error to force Retry");
        }
    }
}
