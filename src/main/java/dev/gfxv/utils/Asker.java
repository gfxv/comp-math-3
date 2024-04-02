package dev.gfxv.utils;

import dev.gfxv.entities.Limits;
import dev.gfxv.exceptions.InvalidInputException;

import java.util.Scanner;

public class Asker {

    public static Limits limitsAsker(Scanner sc) throws InvalidInputException {

        System.out.print("A: ");
        double a = Parser.parseDouble(sc.nextLine());
        System.out.print("B: ");
        double b = Parser.parseDouble(sc.nextLine());

        return new Limits(a, b);
    }

}