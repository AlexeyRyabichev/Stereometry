package com.alexey_ryabichev.stereometry.Variables;

/**
 * Created by alexey_ryabichev on 20.10.16.
 */
public class Point {
    public double x, y, z;
    public boolean isExist = true;
    public String string;

    public Point(boolean isExist, String string){
        this.isExist = isExist;
        this.string = string;
    }

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addNumber(double number){
        x += number;
        y += number;
        z += number;
    }

    public void addVector(Vector vector){
        x += vector.x;
        y += vector.y;
        z += vector.z;
    }
}
