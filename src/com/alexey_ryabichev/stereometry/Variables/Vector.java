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

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private double countLength(){return Math.sqrt(x*x + y*y + z*z);}

    public double getLength(){return length;}

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
