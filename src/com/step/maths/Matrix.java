package com.step.maths;

import java.util.function.Function;

public class Matrix {
    private final int noOfRows;
    private final int noOfColumns;
    private final int[][] values;

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

    public Matrix add(Matrix other) {
        if (!this.areDimensionsEqual(other)) {
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
        if (!this.areDimensionsEqual(other)) {
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
        Matrix result = new Matrix(this.noOfRows, other.noOfColumns);
        if (this.noOfColumns != other.noOfRows) {
            return null;
        }
        for (int thisRowId = 0; thisRowId < this.noOfRows; thisRowId++) {
            for (int otherColId = 0; otherColId < other.noOfColumns; otherColId++) {
                for (int thisColId = 0; thisColId < this.noOfColumns; thisColId++) {
                    int valueA = this.values[thisRowId][thisColId];
                    int valueB = other.values[thisColId][otherColId];
                    result.values[thisRowId][otherColId] += valueA * valueB;
                }
            }
        }
        return result;
    }

    public int getDeterminant() {
        if (this.noOfRows == 1 && this.noOfColumns == 1) {
            return this.values[0][0];
        }
        int determinant = 0;
        for (int cell = 0; cell < this.noOfRows; cell++) {
            double coefficient = Math.pow(-1, cell) * this.values[0][cell];
            Matrix temp = this.getSubMatrix(cell);
            int nextMatrixDeterminant = temp.getDeterminant();
            determinant += coefficient * nextMatrixDeterminant;
        }
        return determinant;
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
        if (!this.areDimensionsEqual(otherMatrix)) {
            return false;
        }
        return this.isDeepEqual(otherMatrix);
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


    private Matrix getSubMatrix(int excludedCol) {

        Matrix temp = new Matrix(this.noOfRows - 1, this.noOfColumns - 1);
        for (int row = 1; row < this.noOfRows; row++) {
            int tempCol = 0;
            for (int col = 0; col < this.noOfColumns; col++) {
                if (col != excludedCol) {
                    temp.values[row - 1][tempCol] = this.values[row][col];
                    tempCol++;
                }
            }
        }
        return temp;
    }

    private boolean isDeepEqual(Matrix matrix) {
        for (int rowId = 0; rowId < this.noOfRows; rowId++) {
            for (int colId = 0; colId < this.noOfColumns; colId++) {
                if (this.values[rowId][colId] != matrix.values[rowId][colId]) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean areDimensionsEqual(Matrix otherMatrix) {
        return (
                this.noOfRows == otherMatrix.noOfRows &&
                        this.noOfColumns == otherMatrix.noOfColumns
        );
    }

}
