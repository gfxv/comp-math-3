package dev.gfxv.funtions;

public class Function3 implements Function {
    @Override
    public double f(double x) {
        return Math.sin(x);
    }

    @Override
    public String toString() {
        return "f(x) = sin(x)";
    }
}
