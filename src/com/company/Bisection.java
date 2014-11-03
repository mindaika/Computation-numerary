package com.company;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Bisection {

    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Randall\\Documents\\Example1b.txt")));
        Bisection Example1 = new Bisection();
        float machineEpsilon = Example1.calculateMachineEpsilonFloat();
        Example1.bisect(0, 1, 100, Math.pow(10, -7), machineEpsilon);
    }

    public void bisect(double a, double b, int M, double delta, float eps) {
        double u = Math.pow(a, -1) - Math.pow(2,a);
        double v = Math.pow(b, -1) - Math.pow(2,b);
        double e = b - a;
        double c, w;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("u = " + u);
        System.out.println("v = " + v + "\n");
        for (int k=1; k < M; k++) {
            if ((int)Math.signum(u) == (int)Math.signum(v)) {
                System.out.println("There is no zero in this interval.");
                return;
            }
            e = e/2;
            c = a + e;
            w = Math.pow(c, -1) - Math.pow(2,c);
            System.out.println("k = " + k);
            System.out.println("c = " + c);
            System.out.println("w = " + w);
            System.out.println("e = " + e + "\n");
            if ((Math.abs(e) < delta) || (Math.abs(w) < eps)) {
                return;
            }
            if ((int)Math.signum(u) != (int)Math.signum(w)) {
                b=c;
                v=w;
            } else {
                a=c;
                u=w;
            }
        }
    }

    public float calculateMachineEpsilonFloat() {
        float machEps = 1.0f;

        do
            machEps /= 2.0f;
        while ((float) (1.0 + (machEps / 2.0)) != 1.0);

        return machEps;
    }

    public double calculateMachineEpsilonDouble() {
        double machEps = 1.0;

        do
            machEps /= 2.0;
        while ((Double) (1.0 + (machEps / 2.0)) != 1.0);

        return machEps;
    }
}
