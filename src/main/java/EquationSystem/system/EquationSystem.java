package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;
import EquationSystem.trigFunctions.Cos;
import EquationSystem.trigFunctions.Sec;
import EquationSystem.trigFunctions.Sin;

public class EquationSystem implements FunctionInterface {

    private LogFunction logFunction;
    private TrigFunction trigFunction;
    private Ln ln;
    private Log log;
    private Sin sin;
    private Cos cos;
    private Sec sec;

    public double calculate(double x) {
        ln = new Ln();
        log = new Log(ln);
        sin = new Sin();
        cos = new Cos(sin);
        sec = new Sec(cos);
        logFunction = new LogFunction(ln, log);
        trigFunction = new TrigFunction(sin, cos, sec);
        if (x > 0) return logFunction.calculate(x);
        else return trigFunction.calculate(x);
    }
}
