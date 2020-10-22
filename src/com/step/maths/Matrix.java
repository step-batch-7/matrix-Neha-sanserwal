package com.step.maths;

public class Matrix {
  private int noOfRows;
  private int noOfColumns;
  private int[][] values;

  public Matrix(int noOfRows, int noOfColumns) {
    this.noOfColumns = noOfColumns;
    this.noOfRows = noOfRows;
    this.values = new int[noOfRows][noOfColumns];
  }

  public static Matrix create(int[][] values) {
    int noOfRows = values.length;
    int noOfColumns = values[0].length;
    Matrix matrix = new Matrix(noOfRows, noOfColumns);
    for (int rowNo = 0; rowNo < values.length; rowNo++) {
      if (values[rowNo].length != noOfColumns) {
        return null;
      }
      System.arraycopy(values[rowNo], 0, matrix.values[rowNo], 0, noOfColumns);
    }
    return matrix;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Matrix:\n");
    for (int[] row : this.values) {
      for (int value : row) {
        stringBuilder.append(value).append(" ");
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  private boolean deepEqual(int[] numbers1, int[] numbers2) {
    if (numbers1 == numbers2) return true;
    if (numbers1 == null || numbers2 == null) return false;
    if (numbers1.length != numbers2.length) return false;
    for (int i = 0; i < numbers2.length; i++) {
      if (numbers1[i] != numbers2[i]) return false;
    }
    return true;
  }

  public boolean areDimensionsEqual(Matrix otherMatrix) {
    return (
      this.noOfRows == otherMatrix.noOfRows &&
      this.noOfColumns == otherMatrix.noOfColumns
    );
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Matrix)) {
      return false;
    }
    if (other == this) {
      return true;
    }
    Matrix otherMatrix = (Matrix) other;
    if (!this.areDimensionsEqual(otherMatrix)) return false;
    for (int row = 0; row < this.noOfRows; row++) {
      if (!deepEqual(this.values[row], otherMatrix.values[row])) return false;
    }
    return true;
  }

  public Matrix add(Matrix other) {
    if (
      this.noOfRows != other.noOfRows || this.noOfColumns != other.noOfColumns
    ) {
      return null;
    }
    Matrix result = new Matrix(this.noOfRows, this.noOfColumns);
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        int sum = this.values[rowNo][colNo] + other.values[rowNo][colNo];
        result.values[rowNo][colNo] = sum;
      }
    }
    return result;
  }

  public Matrix subtract(Matrix other) {
    if (
      this.noOfRows != other.noOfRows && this.noOfColumns != other.noOfColumns
    ) {
      return null;
    }
    Matrix result = new Matrix(this.noOfRows, this.noOfColumns);
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        int difference = this.values[rowNo][colNo] - other.values[rowNo][colNo];
        result.values[rowNo][colNo] = difference;
      }
    }
    return result;
  }

  public Matrix multiply(Matrix other) {
    Matrix result = new Matrix(this.noOfRows, this.noOfColumns);
    for (int rowNo = 0; rowNo < this.noOfRows; rowNo++) {
      for (int colNo = 0; colNo < this.noOfColumns; colNo++) {
        int product = this.values[rowNo][colNo] * other.values[colNo][rowNo];
        result.values[rowNo][colNo] = product;
      }
    }
    return result;
  }

  public int getDeterminant() {
    if (this.noOfRows == 1 && noOfColumns == 1) {
      return this.values[0][0];
    }

    if (this.noOfRows == 2 && noOfColumns == 2) {
      int product1 = this.values[0][0] * this.values[1][1];
      int product2 = this.values[0][1] * this.values[1][0];
      return product1 - product2;
    }
    return 0;
  }
}
