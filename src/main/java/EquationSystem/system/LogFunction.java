package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;

public class LogFunction implements FunctionInterface {

    private Log log;
    private Ln ln;

    public LogFunction(Ln ln, Log log) {
        this.ln = ln;
        this.log = log;
    }

    public double calculate(double x) {
        if (x == 1) throw new IllegalArgumentException("Division by zero");
        return (((((ln.calculate(x) * log.calculate(2,x)) / log.calculate(5,x)) * log.calculate(10,x))
                / (log.calculate(3,x) / log.calculate(3,x))) + log.calculate(5,x));
    }
}
