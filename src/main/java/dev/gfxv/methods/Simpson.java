package dev.gfxv.methods;


import dev.gfxv.entities.Limits;
import dev.gfxv.funtions.Function;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Simpson implements IntegralSolver {

    Function function;
    Limits limits;

    @Override
    public double solve(int n) {

        double length = (limits.getB() - limits.getA() ) / n;

        double oddSum = 0;
        double evenSum = 0;

        double y0 = function.f(limits.getA());
        double yn = function.f(limits.getB());

        double finalSum = y0 + yn;

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                evenSum += function.f(limits.getA() + i * length);
                continue;
            }

            oddSum += function.f(limits.getA() + i * length);
        }

        finalSum += 4 * oddSum + 2 * evenSum;

        return length / 3 * finalSum;
    }

    @Override
    public String toString() {
        return "Simpson's Method";
    }
}
