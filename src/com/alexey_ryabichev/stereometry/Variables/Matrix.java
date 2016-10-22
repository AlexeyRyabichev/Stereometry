package com.alexey_ryabichev.stereometry.Variables;

/**
 * Created by alexey_ryabichev on 22.10.16.
 */
public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double determinant3x3() {
        return matrix[0][0] * matrix[1][1] * matrix[2][2] + matrix[0][2] * matrix[1][0] * matrix[2][1] + matrix[0][1] * matrix[1][2] * matrix[2][0] - matrix[0][2] * matrix[1][1] * matrix[2][0] - matrix[0][0] * matrix[1][2] * matrix[2][1] - matrix[0][1] * matrix[1][0] * matrix[2][2];
    }

    public double determinant2x2() {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
}
