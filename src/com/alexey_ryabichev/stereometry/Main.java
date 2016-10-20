package com.alexey_ryabichev.stereometry;

import com.alexey_ryabichev.stereometry.Variables.Vector;

import java.util.*;

/**
 * Created by alexey_ryabichev on 20.10.16.
 */
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, World!");
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
    
}