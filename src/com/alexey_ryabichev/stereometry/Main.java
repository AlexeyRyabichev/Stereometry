package com.alexey_ryabichev.stereometry;

import com.alexey_ryabichev.stereometry.Variables.*;
import com.alexey_ryabichev.stereometry.Variables.Vector;

import java.util.*;

/**
 * Created by alexey_ryabichev on 20.10.16.
 */
public class Main {
    public static Vector I = new Vector(1, 0, 0);
    public static Vector J = new Vector(0, 1, 0);
    public static Vector K = new Vector(0, 0, 1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    private Vector newVector(Scanner in) {
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

    private double scalar(Vector vector1, Vector vector2) {
        return (vector1.x * vector2.x) + (vector1.y * vector2.y) + (vector1.z * vector2.z);
    }

    private Vector vectoral(Vector vector1, Vector vector2) {
        return new Vector(vector1.y * vector2.z - vector1.z * vector2.y, vector1.z * vector2.x - vector1.x * vector2.z, vector1.x * vector2.y - vector1.y * vector2.x);
    }

    private double angleBetweenVectors(Vector vector1, Vector vector2) {
        return Math.acos(((scalar(vector1, vector2)) / ((vector1.length) * (vector2.length))) * 180 / Math.PI);
    }

    private double distanceBetweenPoints(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2) + Math.pow(point2.z - point1.z, 2));
    }

    private double distanceBetweenPointAndLine(Point point, Line line) {
        Vector u = new Vector(line);
        Vector l = new Vector(projectionPointOnLine(point, line), line.point1);
        return Math.sqrt(Math.pow(u.length, 2) - Math.pow(l.length, 2));
    }

    private Point projectionPointOnLine(Point point, Line line) {
        Vector u = new Vector(line);
        Vector v = new Vector(new Line(line.point1.x, line.point1.y, line.point1.z, point.x, point.y, point.z));
        Point p = new Point(line.point1.x, line.point1.y, line.point1.z);
        double number = scalar(u, v) / Math.pow(v.length, 2);
        p.addNumber(number);
        return p;
    }

    private Point projectPointOnPlane(Point point, Plane plane){
        Point point1 = new Point(point.x, point.y, point.z);
        point1.addVector(plane.n);
        Line line = new Line(point, point1);
        return intersectLineAndPlane(line, plane);
    }

    private Point intersectLineAndPlane(Line line, Plane plane){
        double sum = line.x1 * plane.a + line.y1 * plane.b + line.z1 * plane.c + plane.d;
        double parametrFactor = -(line.nx * plane.a + line.ny * plane.b + line.nz * plane.c);

        if (sum == 0 && parametrFactor == 0)
            return new Point(false, "CONTAIN");

        if (sum != 0 && parametrFactor == 0)
            return new Point(false, "PARALLEL");

        double parametr = sum / parametrFactor;

        return new Point(line.x1 + parametr * line.nx, line.y1 + parametr * line.ny, line.z1 + parametr * line.nz);
    }

    public Line projectLineOnPlane(Line line, Plane plane){
        Point point1 = projectPointOnPlane(line.point1, plane);
        Point point2 = projectPointOnPlane(line.point2, plane);
        if (point1 == point2)
            return new Line(point1, point1);
        return new Line(point1, point2);
    }

    private Point attitudePoint(double coeff, Segment segment) {
        double x = (segment.point1.x + coeff * segment.point2.x) / (1 + coeff);
        double y = (segment.point1.y + coeff * segment.point2.y) / (1 + coeff);
        double z = (segment.point1.z + coeff * segment.point2.z) / (1 + coeff);
        return new Point(x, y, z);
    }

    private Vector vectorByBasis(Vector i, Vector j, Vector k, Vector e) {
        double[][] value = {{i.x, j.x, k.x}, {i.y, j.y, k.y}, {i.z, j.z, k.z}};
        double[][] value1 = {{e.x, j.x, k.x}, {e.y, j.y, k.y}, {e.z, j.z, k.z}};
        double[][] value2 = {{i.x, e.x, k.x}, {i.y, e.y, k.y}, {i.z, e.z, k.z}};
        double[][] value3 = {{i.x, j.x, e.x}, {i.y, j.y, e.y}, {i.z, j.z, e.z}};
        double d = new Matrix(value).determinant3x3();
        double da = new Matrix(value1).determinant3x3();
        double db = new Matrix(value2).determinant3x3();
        double dc = new Matrix(value3).determinant3x3();
        return new Vector(da / d, db / d, dc / d);
    }

    private double distanceBetweenPointAndPlane(Point point, Plane plane) {
        return (plane.a * point.x + plane.b * point.y + plane.c * point.z + plane.d) / Math.sqrt(Math.pow(plane.a, 2) + Math.pow(plane.b, 2) + Math.pow(plane.c, 2));
    }

    private double angleBetweenLines(Line line1, Line line2) {
        return angleBetweenVectors(line1.n, line2.n);
    }

    private double angleBetweenLineAndPlane(Plane plane, Line line) {
        return angleBetweenVectors(line.n, plane.n);
    }

    private double angleBetweenPlanes(Plane plane1, Plane plane2) {
        return angleBetweenVectors(plane1.n, plane2.n);
    }

    private double mixed(Vector vector1, Vector vector2, Vector vector3) {
        double[][] value = {{vector1.x, vector1.y, vector1.z}, {vector2.x, vector2.y, vector2.z}, {vector3.x, vector3.y, vector3.z}};
        return new Matrix(value).determinant3x3();
    }

    private boolean ifKollinear(Vector vector1, Vector vector2) {
        return vectoral(vector1, vector2).length == 0;
    }

    private boolean ifKomplonarn(Vector vector1, Vector vector2, Vector vector3) {
        return mixed(vector1, vector2, vector3) == 0;
    }

    private String dispositionOfLines(Line line1, Line line2) {
        if (line1.n.x / line2.n.x == line1.n.y / line2.n.y && line1.n.y / line2.n.y == line1.n.z / line2.n.z)
            return "MATCH";

        if (line1.n.x / line2.n.x == line1.n.y / line2.n.y && line1.n.y / line2.n.y != line1.n.z / line2.n.z)
            return "PARALLEL";

        if (line1.n.x / line2.n.x != line1.n.y / line2.n.y)
            return "INTERSECTING";

        return "SKEW";
    }

    public String dispositionOfLineAndPlane(Line line, Plane plane){
        if (scalar(line.n, plane.n) != 0)
            return "INTERSECT";
        if (plane.a * line.point1.x + plane.b * line.point1.y + plane.c * line.point1.z + plane.d != 0)
            return "PARALLEL";
        return "MATCH";
    }

//    private double distanceBetweenLines(Line line1, Line line2){
//        if (dispositionOfLines(line1, line2) == "SKEW")
//            return 0.0;
//        if (dispositionOfLines(line1, line2) == "PARALLEL")
//            return distanceBetweenPointAndLine(line1.point1, line2);
//        else
//            return 0.0; // Intersecting or match
//    }

    private double tetrahedronVolume(Point point1, Point point2, Point point3, Point point4){
        return mixed(new Vector(point1, point2), new Vector(point1, point3), new Vector(point1, point4)) / 6.0;
    }

    private String getVectorsOrientation(Vector vector1, Vector vector2, Vector vector3){
        double[][] value = {{vector1.x, vector1.y, vector1.z}, {vector2.x, vector2.y, vector2.z}, {vector3.x, vector3.y, vector3.z}};
        double determinant = new Matrix(value).determinant3x3();
        if (determinant > 0.0)
            return "RIGHT";
        if (determinant < 0.0)
            return "LEFT";
        return "UNDEFINED";
    }

    private double distanceBetweenLineAndPlane(Line line, Plane plane){
        if (dispositionOfLineAndPlane(line, plane) == "PARALLEL")
            return distanceBetweenPointAndPlane(line.point1, plane);
        return -1;
    }

//    private String intersect

    private double volumeBox(Vector vector1, Vector vector2, Vector vector3){
        double[][] value = {{vector1.x, vector1.y, vector1.z}, {vector2.x, vector2.y, vector2.z}, {vector3.x, vector3.y, vector3.z}};
        return Math.abs(new Matrix(value).determinant3x3());
    }
}