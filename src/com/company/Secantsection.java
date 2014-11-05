package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by rs on 11/4/2014.
 */
public class Secantsection {
    public static void main(String args[]) throws FileNotFoundException {
        Secantsection section = new Secantsection();
        System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\rs\\OneDrive\\Documents\\CS451\\CP33P1boutput.txt")));
        section.secant(-3.5, -3, 100, Math.pow(10, -20), MachineEpsilon.calculateMachineEpsilonDouble());
    }

    public double secant(double a, double b, int M, double delta, double epsilon) {
        double fa = f(a);
        double fb = f(b);
        double s;
        System.out.format("%5s%20s%20s\n", "n", "x_n", "f(x_n)");
        System.out.format("%5d%20G%20G\n", 0, a, fa);
        System.out.format("%5d%20G%20G\n", 1, b, fb);
        for(int k=2; k<M; k++) {
            if (Math.abs(fa) > Math.abs(fb)) {
                double temp=a;
                a=b;
                b=temp;

                temp=fa;
                fa=fb;
                fb=temp;
            }
            s=(b-a)/(fb-fa);
            b=a;
            fb=fa;
            a=(a-(fa*s));
            fa=f(a);
            System.out.format("%5d%20G%20G\n", k, a, fa);
            if ((Math.abs(fa) < epsilon) || Math.abs(b-a) < delta) {
                System.out.println("Root: " + a);
                return a;
            }
        }
        System.out.println("Root: " + a);
        return a;
    }

    public double f(double x) {
        return (Math.pow(Math.E,x) - Math.tan(x));
//        return ((Math.pow(x,3) - Math.sinh(x) + 4*Math.pow(x,2) + 6*x + 9));
    }
}
