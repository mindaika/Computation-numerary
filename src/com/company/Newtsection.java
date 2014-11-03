package com.company;

/**
 * Created by Randall on 11/3/2014.
 */
public class Newtsection {
    public static void main(String args[]) throws Exception {
        Newtsection newnewt = new Newtsection();
        newnewt.newton(10,10,10,10,10);

    }

    public void newton(double x, double y, double h, int M, int N) throws Exception {
        System.out.println("0");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("G(x,y) = " + Math.tan(x));
        for (int i=1; i<M; i++) {
            x = x + h;
            for (int j=1; j<N; j++){
                y = y - 10/2; //Actually, should be G(x,y)/(dG/dy)(x,y)
            }
            System.out.println("i = " + i);
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            System.out.println("G(x,y) = " + Math.tan(x));

        }
    }
}
