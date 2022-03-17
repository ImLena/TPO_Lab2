package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;

public class LogFunction implements FunctionInterface {

    private Log log2;
    private Log log3;
    private Log log5;
    private Log log10;
    private Ln ln;

    public LogFunction(Ln ln, Log log2, Log log3, Log log5, Log log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public double calculate(double x) {
        if (x == 1) throw new IllegalArgumentException("Division by zero");
        return (((((ln.calculate(x) * log2.calculate(x)) / log5.calculate(x)) * log10.calculate(x))
                / (log3.calculate(x) / log3.calculate(x))) + log5.calculate(x));
    }
}
