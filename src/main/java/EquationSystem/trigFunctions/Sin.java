package EquationSystem.trigFunctions;

import EquationSystem.FunctionInterface;

public class Sin implements FunctionInterface {

    public static final double ACCURACY = 0.01;

    private double sinTailor(double val, int n) {
        return Math.pow(-1, n) * Math.pow(val, 2 * n + 1) / factorial(2 * n + 1);
    }

    public double calculate(double x) {
        double result = 0.0;
        double curr = 10.0;
        double prev = 0.0;
        int n = 0;

        while (Math.abs(prev - curr) >= ACCURACY) {
            prev = curr;
            curr = sinTailor(x, n);
            result += curr;
            n++;
        }
        return result;
    }

    private long factorial(long val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }

    public double getAccuracy() {
        return ACCURACY;
    }
}
