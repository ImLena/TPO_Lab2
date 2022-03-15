package EquationSystem;

import EquationSystem.system.EquationSystem;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        EquationSystem equationSystem = new EquationSystem();
        System.out.println("x <= 0 : sec(x)\n" +
                "x > 0 : (((((ln(x) * log_2(x)) / log_5(x)) * log_10(x)) / (log_3(x) / log_3(x))) + log_5(x))");
        System.out.println(equationSystem.calculate(readValue()));
    }

    private static double readValue(){
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
