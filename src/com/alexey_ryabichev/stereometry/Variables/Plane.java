package com.alexey_ryabichev.stereometry.Variables;

import com.alexey_ryabichev.stereometry.Main;

/**
 * Created by alexey_ryabichev on 21.10.16.
 */
public class Plane {
    public double a, b, c, d;
    Point point1, point2, point3;
    Vector n = null;

    public Plane(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        n = new Vector(a, b, c);
    }

    public Plane(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        n = vectoral(new Vector(point1, point2), new Vector(point1, point3));
        a = n.x;
        b = n.y;
        c = n.z;
        d = -(a*point1.x + b*point1.y + c*point1.z);
    }

    private Vector vectoral(Vector vector1, Vector vector2) {
        return new Vector(vector1.y * vector2.z - vector1.z * vector2.y, vector1.z * vector2.x - vector1.x * vector2.z, vector1.x * vector2.y - vector1.y * vector2.x);
    }
}
