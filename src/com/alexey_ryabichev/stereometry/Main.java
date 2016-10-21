package com.alexey_ryabichev.stereometry;

import com.alexey_ryabichev.stereometry.Variables.Line;
import com.alexey_ryabichev.stereometry.Variables.Point;
import com.alexey_ryabichev.stereometry.Variables.Segment;
import com.alexey_ryabichev.stereometry.Variables.Vector;

import java.util.*;

/**
 * Created by alexey_ryabichev on 20.10.16.
 */
public class Main{
    public static Vector I = new Vector(1, 0, 0);
    public static Vector J = new Vector(0, 1, 0);
    public static Vector K = new Vector(0, 0, 1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    private Vector newVector(Scanner in){
        double x, y, z;
        Vector vector;
        System.out.println("x: ");
        x = in.nextDouble();
        System.out.println("y: ");
        y = in.nextDouble();
        System.out.println("z: ");
        z = in.nextDouble();
        vector = new Vector(x, y, z);
        return vector;
    }

    private double scalar(Vector vector1, Vector vector2){
        return (vector1.x * vector2.x) + (vector1.y * vector2.y) + (vector1.z * vector2.z);
    }

    private Vector vectoral(Vector vector1, Vector vector2){
        return new Vector(vector1.y * vector2.z - vector1.z * vector2.y, vector1.z * vector2.x - vector1.x * vector2.z, vector1.x * vector2.y - vector1.y * vector2.x);
    }

    private double angleBetweenVectors(Vector vector1, Vector vector2){
        return (scalar(vector1, vector2)) / ((vector1.length) * (vector2.length));
    }

    private double distanceBetweenPoints(Point point1, Point point2){
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2) + Math.pow(point2.z - point1.z, 2));
    }

    private double distanceBetweenPointAndLine(Point point, Line line){
        Vector u = new Vector(line);
        Vector l = new Vector(projectionPointOnLine(point, line),line.point1);
        return Math.sqrt(Math.pow(u.length, 2) - Math.pow(l.length, 2));
    }

    private Point projectionPointOnLine(Point point, Line line){
        Vector u = new Vector(line);
        Vector v = new Vector(new Line(line.point1.x, line.point1.y, line.point1.z, point.x, point.y, point.z));
        Point p = new Point(line.point1.x, line.point1.y, line.point1.z);
        double number = scalar(u, v) / Math.pow(v.length, 2);
        p.addNumber(number);
        return p;
    }

    private Point attitudePoint(double coeff, Segment segment){
        double x = (segment.point1.x + coeff*segment.point2.x) / (1 + coeff);
        double y = (segment.point1.y + coeff*segment.point2.y) / (1 + coeff);
        double z = (segment.point1.z + coeff*segment.point2.z) / (1 + coeff);
        return new Point(x, y, z);
    }
}