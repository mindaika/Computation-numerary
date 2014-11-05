package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Randall on 11/3/2014.
 */

public class Newtsection {
    public static void main(String args[]) throws Exception {
        Newtsection newnewt = new Newtsection();
//        System.setOut(new PrintStream(new FileOutputStream("F:\\OneDrive\\Documents\\CS451\\CP32P1output.txt")));
        newnewt.newton(7.7, 100, Math.pow(10,-20));
        newnewt.newton(4.5, 100, Math.pow(10,-20));
    }

    public void newton(double x0, int M, double delta) throws Exception {
        System.out.format("%5s%20s%20s\n", "k", "x", "f(x)");
        double epsilon = MachineEpsilon.calculateMachineEpsilonDouble();
        double v = f(x0);
        double x1;
        System.out.format("%5d%20G%20G\n", 0, x0, v);
        if (Math.abs(v) < epsilon) {
            System.out.println("Stopping because of v");
            return;
        }
        for (int k=1; k<M; k++) {
            x1 = (x0 - (v / fPrime(x0)));
            v = f(x1);
            System.out.format("%5d%20G%20G\n", k, x1, v);
            if (((Math.abs(x1 - x0)) < delta) || (Math.abs(v) < epsilon)) {
                System.out.println("Stopping because I hit an error bound");
                return;
            }
            x0 = x1;
        }
    }

    public double f(double x){
        return (x - Math.tan(x));
//        return (Math.pow(Math.E,x) - 1.5 - Math.atan(x));
    }

    public double fPrime(double x) {
        return (-1)*(Math.pow(Math.tan(x),2));
//        return Math.pow (sec(x),2);
//        return (Math.pow(Math.E,x) - Math.pow((1 + Math.pow(x,2)),-1));
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
