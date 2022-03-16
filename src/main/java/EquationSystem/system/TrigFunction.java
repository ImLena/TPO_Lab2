package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.trigFunctions.Sec;

public class TrigFunction implements FunctionInterface {
    private Sec sec;

    public TrigFunction(Sec sec) {
        this.sec = sec;
    }

    public double calculate(double x) {
        return sec.calculate(x);
    }
}
