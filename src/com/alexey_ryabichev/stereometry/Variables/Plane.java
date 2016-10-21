package com.alexey_ryabichev.stereometry.Variables;

/**
 * Created by alexey_ryabichev on 21.10.16.
 */
public class Plane {
    public double a, b, c, d;
    Point point1, point2, point3;

    public Plane(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Plane(Point point1, Point point2, Point point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }
}
