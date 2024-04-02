package dev.gfxv;

import dev.gfxv.entities.Limits;
import dev.gfxv.exceptions.InvalidInputException;
import dev.gfxv.funtions.Function;
import dev.gfxv.funtions.Function1;
import dev.gfxv.funtions.Function2;
import dev.gfxv.funtions.Function3;
import dev.gfxv.methods.*;
import dev.gfxv.utils.Asker;
import dev.gfxv.utils.Parser;
import dev.gfxv.utils.Printer;

import java.util.Scanner;

public class Application {

    private static int n = 10;

    public static void main(String[] args) {

        Function[] functions = { new Function1(), new Function2(), new Function3() };

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Choose function:");

            Printer.printFunctions(functions);

            System.out.printf("Type a number from 1 to %d to choose: ", functions.length);

            int funcIndex = Parser.parseInt(sc.nextLine());
            if (funcIndex < 0 || funcIndex > functions.length) {
                throw new InvalidInputException("Input should be between 1 and " + functions.length);
            }

            Function function = functions[funcIndex - 1];

            System.out.println("Input limits for integral");
            Limits limits = Asker.limitsAsker(sc);
            System.out.print("Input precision: ");
            double e = Parser.parseDouble(sc.nextLine());


            IntegralSolver[] solvers = {
                    new LeftRectangle(function, limits),
                    new MidRectengle(function, limits),
                    new RightRectangle(function, limits),
                    new Simpson(function, limits),
                    new Trapezoid(function, limits),
            };

            System.out.println("Choose method:");

            Printer.printMethods(solvers);

            int methodIndex = Parser.parseInt(sc.nextLine());
            if (methodIndex < 0 || methodIndex > solvers.length) {
                throw new InvalidInputException("Input should be between 1 and " + solvers.length);
            }


            IntegralSolver solver = solvers[methodIndex - 1];
            double big = solver.solve(n);
            double smol = solver.solve(n * 2);
            while (Math.abs(big-smol) > e) {
                n *= 2;
                big = solver.solve(n);
                smol = solver.solve(n * 2);
            }

            System.out.println("Amount of intervals: " + n);
            System.out.println("Result: " + smol);


        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
