package com.alexey_ryabichev.stereometry.Variables;

/**
 * Created by alexey_ryabichev on 21.10.16.
 */
public class Line {
    public Point point1, point2;
    public Vector n;
    public double x1, y1, z1, nx, ny, nz;

    public Line(double x1, double y1, double z1, double x2, double y2, double z2) {
        point1.x = x1;
        point1.y = y1;
        point1.z = z1;
        point2.x = x2;
        point2.y = y2;
        point2.z = z2;
        n = new Vector(point1, point2);
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        nx = x2 - x1;
        ny = y2 - y1;
        nz = z2 - z1;
    }

    public Line(Point point1, Point point2){
        this.point1 = point1;
        this.point2 = point2;
        n = new Vector(point1, point2);
        x1 = point1.x;
        y1 = point1.y;
        z1 = point1.z;
        nx = point2.x - point1.x;
        ny = point2.y - point1.y;
        nz = point2.z - point1.z;
    }
}
