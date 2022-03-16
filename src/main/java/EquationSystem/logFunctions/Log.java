package EquationSystem.logFunctions;

public class Log {
    private final Ln ln;

    public Log(Ln ln) {
        this.ln = ln;
    }

    public double calculate( double base, double x) {
        return ln.calculate(x) / ln.calculate(base);
    }
}
