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
public class RightRectangle implements IntegralSolver {

    Function function;
    Limits limits;

    @Override
    public double solve(int n) {
        double length = (limits.getB() - limits.getA() ) / n;

        double result = 0;

        for (int i = 1; i <= n; i++) {
            double x =  (limits.getA() + i * length);
            double y = function.f(x);
            result += y;
        }

        return result * length;
    }

    @Override
    public String toString() {
        return "Right Rectangle Method";
    }
}
