package com.alexey_ryabichev.stereometry.Variables;

import com.alexey_ryabichev.stereometry.Variables.Point;
import com.sun.java_cup.internal.runtime.Symbol;
import java.util.*;

/**
 * Created by alexey_ryabichev on 20.10.16.
 */
public class Vector {
    public double x, y, z;
    public double length = countLength();
    public Point point1, point2;

    public Vector(double x1, double y1, double z1, double x2, double y2, double z2){
        point1.x = x1;
        point1.y = y1;
        point1.z = z1;
        point2.x = x2;
        point2.y = y2;
        point2.z = z2;
        x = x2 - x1;
        y = y2 - y1;
        z = z2 - z1;
    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Line line){
        point1.x = line.point1.x;
        point1.y = line.point1.y;
        point1.z = line.point1.z;
        point2.x = line.point2.x;
        point2.y = line.point2.y;
        point2.z = line.point2.z;
        x = point2.x - point1.x;
        y = point2.y - point1.y;
        z = point2.z - point1.z;
    }

    private double countLength(){return Math.sqrt(x*x + y*y + z*z);}

    public void plusNumber(double number){
        x += number;
        y += number;
        z += number;
        length = countLength();
    }

    public void minusNumber(double number){
        x -= number;
        y -= number;
        z -= number;
        length = countLength();
    }

    public void multiplyNumber(double number){
        x *= number;
        y *= number;
        z *= number;
        length = countLength();
    }
}
