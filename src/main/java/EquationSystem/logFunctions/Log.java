package EquationSystem.logFunctions;

import EquationSystem.FunctionInterface;

public class Log implements FunctionInterface {
    private final Ln ln;
    private final double base;

    public Log(Ln ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    public double calculate(double x) {
        if (x < 0 || base <=0 || base == 1) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        return ln.calculate(x) / ln.calculate(base);
    }
}
