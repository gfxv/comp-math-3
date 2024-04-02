package dev.gfxv.utils;

import dev.gfxv.funtions.Function;
import dev.gfxv.methods.IntegralSolver;

public class Printer {

    public static void printFunctions(Function[] functions) {
        int counter = 1;
        for (Function function : functions) {
            System.out.printf("(%d) %s\n", counter, function);
            counter++;
        }

    }

    public static void printMethods(IntegralSolver[] solvers) {
        int counter = 1;
        for (IntegralSolver m : solvers) {
            System.out.printf("(%d) %s\n", counter, m);
            counter++;
        }
    }
}
