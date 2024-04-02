package dev.gfxv.funtions;

public class Function2 implements Function {

    @Override
    public double f(double x) {
        return Math.sqrt(2 * x + 10);
    }

    @Override
    public String toString() {
        return "f(x) = √(2x + 10)";
    }
}
