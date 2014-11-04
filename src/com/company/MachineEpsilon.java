package com.company;

/**
 * Created by Randall on 11/3/2014.
 */
public class MachineEpsilon {
    public static float calculateMachineEpsilonFloat() {
        float machEps = 1.0f;

        do
            machEps /= 2.0f;
        while ((float) (1.0 + (machEps / 2.0)) != 1.0);

        return machEps;
    }

    public static double calculateMachineEpsilonDouble() {
        double machEps = 1.0;

        do
            machEps /= 2.0;
        while ((Double) (1.0 + (machEps / 2.0)) != 1.0);

        return machEps;
    }
}
