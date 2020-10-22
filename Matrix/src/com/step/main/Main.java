package com.step.main;

import com.step.maths.Matrix;

public class Main {

  public static Matrix addMatrix() {
    int[][] valuesA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[][] valuesB = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    Matrix matrixB = Matrix.create(valuesA);
    Matrix matrixA = Matrix.create(valuesB);
    return matrixA.add(matrixB);
  }

  public static Matrix subtractMatrix() {
    int[][] valuesA = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
    int[][] valuesB = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    Matrix matrixB = Matrix.create(valuesA);
    Matrix matrixA = Matrix.create(valuesB);
    return matrixA.subtract(matrixB);
  }

  public static Matrix multiplyMatrix() {
    // int[][] valuesA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // int[][] valuesB = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    // Matrix matrixB = Matrix.create(valuesA);
    // Matrix matrixA = Matrix.create(valuesB);
    // return matrixA.multiply(matrixB);

    int[][] valuesC = { { 1, 2, 3 }, { 4, 5, 6 } };
    int[][] valuesD = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
    Matrix matrixC = Matrix.create(valuesC);
    Matrix matrixD = Matrix.create(valuesD);
    return matrixC.multiply(matrixD);
  }

  public static void calculateDeterminant() {
    int[][] valuesA = { { 5 } };
    Matrix matrixA = Matrix.create(valuesA);
    System.out.println(
      "Determinant for 1 * 1 matrix with one element : " +
      matrixA.getDeterminant()
    );

    int[][] valuesB = { { 1, 2 }, { 3, 4 } };

    Matrix matrixB = Matrix.create(valuesB);
    System.out.println(
      "Determinant for 2 * 2 matrix : " + matrixB.getDeterminant()
    );
  }

  public static void main(String[] args) {
    // System.out.println(addMatrix());
    // System.out.println(subtractMatrix());
    // System.out.println(multiplyMatrix());
    calculateDeterminant();
  }
}
