package EquationSystem.logFunctions;

import EquationSystem.FunctionInterface;

public class Ln implements FunctionInterface {

    private static final double ACCURACY = 0.01;

    public Ln() {
    }

    private double lnTailor(double val, int n) {
        return Math.pow(-1, n - 1) * Math.pow(val - 1, n) / n;
    }

    public double calculate(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        if (x > 2) return calculate(x / 2.0) + calculate(2.0);

        double prev = 0.0;
        double result = 0.0;
        double curr = 10.0;
        int n = 1;

        while (Math.abs(prev - curr) > ACCURACY) {
            prev = curr;
            curr = lnTailor(x, n);
            result += curr;
            n++;
        }
        return result;
    }

    public double getAccuracy() {
        return ACCURACY;
    }
}
