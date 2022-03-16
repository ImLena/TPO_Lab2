package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.trigFunctions.Cos;
import EquationSystem.trigFunctions.Sec;
import EquationSystem.trigFunctions.Sin;

public class TrigFunction implements FunctionInterface {
    private Sec sec;

    public TrigFunction(Sec sec) {
        this.sec = sec;
    }

    public double calculate(double x) {
        return sec.calculate(x);
    }
}
