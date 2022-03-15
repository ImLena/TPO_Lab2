package EquationSystem.trigFunctions;

import EquationSystem.FunctionInterface;

public class Sec implements FunctionInterface {

    private Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double calculate(double x) {
        if ((x - Math.PI / 2) % Math.PI != 0) {
            return 1 / cos.calculate(x);
        } else {
            return Double.NaN;
        }
    }
}
