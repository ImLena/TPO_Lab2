package EquationSystem.system;

import EquationSystem.FunctionInterface;
import EquationSystem.trigFunctions.Cos;
import EquationSystem.trigFunctions.Sec;
import EquationSystem.trigFunctions.Sin;

public class TrigFunction implements FunctionInterface {

    private Sin sin;
    private Cos cos;
    private Sec sec;

    public TrigFunction(Sin sin, Cos cos, Sec sec) {
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
    }

    public double calculate(double x) {
        return sec.calculate(x);
    }
}
