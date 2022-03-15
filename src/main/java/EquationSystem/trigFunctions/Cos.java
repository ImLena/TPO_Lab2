package EquationSystem.trigFunctions;

import EquationSystem.FunctionInterface;

public class Cos implements FunctionInterface {

    private Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        return 1 - 2 * Math.pow(sin.calculate(x / 2), 2);
    }
}
