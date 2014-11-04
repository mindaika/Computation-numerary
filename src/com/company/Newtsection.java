package com.company;

/**
 * Created by Randall on 11/3/2014.
 */

public class Newtsection {
    public static void main(String args[]) throws Exception {
        Newtsection newnewt = new Newtsection();
        newnewt.newton(5, 100, Math.pow(10,-10));
    }

    public void newton(double x0, int M, double delta) throws Exception {
        double epsilon = MachineEpsilon.calculateMachineEpsilonDouble();
        double v = Math.tan(x0);
        System.out.println("0 = 0");
        System.out.println("x0 = " + x0);
        System.out.println("v = " + v + "\n");
        if (Math.abs(v) < epsilon) {
            System.out.println("Stopping because of v");
            return;
        }
        for (int k=1; k<M; k++) {
            double x1 = (x0 - (v / fPrime(x0)));
            v = f(x1);
            System.out.println("k = " + k);
            System.out.println("x = " + x1);
            System.out.println("f(x) = " + v + "\n");
            if (((Math.abs(x1) - Math.abs(x0)) < delta) || (Math.abs(v) < epsilon)) {
                System.out.println("Stopping because I hit an error bound");
                return;
            }
            x0 = x1;
        }
    }

    public double f(double x){
        return Math.tan(x);
    }

    public double fPrime(double x) {
        return Math.pow (sec(x),2);
    }

    /**
     * compute secant
     * @param theta angle in radians
     * @return secant of theta.
     * Stoled from a website, but a trivial function regardless
     */
    public double sec ( double theta )
    {
        return 1.0 / Math.cos( theta );
    }
}
