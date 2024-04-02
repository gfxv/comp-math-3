package dev.gfxv.methods;


import dev.gfxv.entities.Limits;
import dev.gfxv.funtions.Function;
import dev.gfxv.funtions.Function3;
import org.w3c.dom.ls.LSOutput;

public class NewtonCotes {

    public static void solve() {
        double a = 1;
        double b = 2;
        double n = 6;
        double h = (b - a) / n;

        System.out.println(h);

        // source: https://ee.kpi.ua/~vk/calcmat/lab/int_ru.pdf , page 3
        int CSum = 840;
        int[] cCoeff = { 41, 216, 27, 272, 27, 216 };

        double sum = 0;
        for (int i = 0; i < n; i++) {
            double y = f(a + i * h);
            sum += (cCoeff[i] * y);
        }

        double result = n * h / CSum * sum;
        System.out.println(result);

        Limits limit = new Limits(a, b);
        Function function = NewtonCotes::f;

        IntegralSolver midRect = new MidRectengle(function, limit);
        IntegralSolver trapezoid = new Trapezoid(function, limit);
        IntegralSolver simpson = new Simpson(function, limit);

        System.out.println(midRect.solve(10));
        System.out.println(trapezoid.solve(10));
        System.out.println(simpson.solve(10));
    }


    private static double f(double x) {
        return Math.pow(x, 3) + 2 * Math.pow(x, 2) - 3 * x - 12;
    }

}
