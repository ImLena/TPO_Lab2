package EquationSystem;

import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;
import EquationSystem.system.EquationSystem;
import EquationSystem.system.LogFunction;
import EquationSystem.system.TrigFunction;
import EquationSystem.trigFunctions.Cos;
import EquationSystem.trigFunctions.Sec;
import EquationSystem.trigFunctions.Sin;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ln ln;
        Log log2;
        Log log3;
        Log log5;
        Log log10;
        Sin sin;
        Cos cos;
        Sec sec;
        LogFunction logFunction;
        TrigFunction trigFunction;
        ln = new Ln();
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log5 = new Log(ln, 5);
        log10 = new Log(ln, 10);
        sin = new Sin();
        cos = new Cos(sin);
        sec = new Sec(cos);
        logFunction = new LogFunction(ln, log2, log3, log5, log10);
        trigFunction = new TrigFunction(sec);
        EquationSystem equationSystem = new EquationSystem(logFunction, trigFunction);
        System.out.println("x <= 0 : sec(x)\n" +
                "x > 0 : (((((ln(x) * log_2(x)) / log_5(x)) * log_10(x)) / (log_3(x) / log_3(x))) + log_5(x))");
        System.out.println(equationSystem.calculate(readValue()));
    }

    private static double readValue() {
        double num = 0.0;
        try {
            System.out.println("Введите число:");
            num = Double.parseDouble(new Scanner(System.in).nextLine());
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Ожидалось число");
            System.exit(0);
        }
        return num;
    }
}
