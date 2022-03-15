package EquationSystem.logFunctions;

public class Log {
    private Ln ln;
    private double base;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double calculate( double base, double x) {
        System.out.println(base +" "+ x);
        if (base <= 0 || base == 1) return Double.NaN;
        return ln.calculate(x) / ln.calculate(base);
    }
}
