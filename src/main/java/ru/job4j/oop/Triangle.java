package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double semiPerimeter(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return !(ab >= ac + bc) && !(ac >= bc + ab) && !(bc >= ab + ac);
    }

    public double area() {
        double rsl = -1;
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        double semiP = semiPerimeter(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = sqrt(semiP * (semiP - ab) * (semiP - ac) * (semiP - bc));
        }
        return rsl;
    }
}