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

    public EquationSystem(LogFunction logFunction, TrigFunction trigFunction) {
        this.logFunction = logFunction;
        this.trigFunction = trigFunction;
    }

    public double calculate(double x) {
        if (x > 0) return logFunction.calculate(x);
        else return trigFunction.calculate(x);
    }
}
