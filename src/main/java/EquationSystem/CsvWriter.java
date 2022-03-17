package EquationSystem;

import EquationSystem.logFunctions.Ln;
import EquationSystem.logFunctions.Log;
import EquationSystem.system.LogFunction;
import EquationSystem.system.TrigFunction;
import EquationSystem.system.EquationSystem;
import EquationSystem.trigFunctions.Cos;
import EquationSystem.trigFunctions.Sec;
import EquationSystem.trigFunctions.Sin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvWriter {
    public static void writeCsv(String function, double begin, double end, double step) throws IOException {
        double res;
        File file = new File("src/main/resources/" + function + ".csv");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        FunctionInterface func = defineFunction(function);
        if (func == null) return;
        for (double x = begin; x <= end; x += step) {
            res = func.calculate(x);
            writer.write(String.format("%f;     %f\n", x, res));

        }
        writer.close();
    }

    public static void main(String[] args) {
        String function = insertFunction();
        try {
            if (function == null) {
                System.out.println("Function is null");
                return;
            }
            double begin = insertDouble("левую границу");
            double end = insertDouble("правую границу");
            double step = insertDouble("шаг");
            writeCsv(function, begin, end, step);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FunctionInterface defineFunction(String f) {
        switch (f) {
            case ("sin"):
                return new Sin();
            case ("cos"):
                return new Cos(new Sin());
            case ("sec"):
                return new Sec(new Cos(new Sin()));
            case ("ln"):
                return new Ln();
            case ("log"):
                double base = insertDouble("основание логарифма");
                if (base <= 0 || base == 1) {
                    System.out.println("Неверное основание");
                    return null;
                }
                return new Log(new Ln(), base);
            case ("logFunction"):
                return new LogFunction(new Ln(), new Log(new Ln(), 2), new Log(new Ln(), 3),
                        new Log(new Ln(), 5), new Log(new Ln(), 10));
            case ("trigFunction"):
                return new TrigFunction(new Sec(new Cos(new Sin())));
            case ("equationSystem"):
                return new EquationSystem(new LogFunction(new Ln(), new Log(new Ln(), 2),
                        new Log(new Ln(), 3), new Log(new Ln(), 5), new Log(new Ln(), 10)),
                        new TrigFunction(new Sec(new Cos(new Sin()))));
            default:
                System.out.println("Неверно введена функция");
                return null;
        }
    }

    public static String insertFunction() {
        Scanner in = new Scanner(System.in);
        String func;
        func = in.nextLine();
        return func;
    }

    public static double insertDouble(String name) {
        System.out.println("Введите " + name);
        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

}