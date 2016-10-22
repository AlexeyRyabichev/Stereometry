package com.alexey_ryabichev.stereometry.Variables;

/**
 * Created by alexey_ryabichev on 21.10.16.
 */
public class Segment {
    public Point point1, point2;

    public Segment(double x1, double y1, double z1, double x2, double y2, double z2) {
        point1.x = x1;
        point1.y = y1;
        point1.z = z1;
        point2.x = x2;
        point2.y = y2;
        point2.z = z2;
    }
}
