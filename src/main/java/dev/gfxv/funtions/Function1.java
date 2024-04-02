package dev.gfxv.funtions;

public class Function1 implements Function {

    @Override
    public double f(double x) {
        return Math.pow(x, 2) + 8 * x + 12;
    }

    @Override
    public String toString() {
        return "f(x) = x^2 + 8x + 12";
    }

}
