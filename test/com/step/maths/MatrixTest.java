package com.step.maths;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

    @Test
    public void shouldReturnTextualFromOfMatrix() {
        Matrix matrix = new Matrix(0, 0);
        assertEquals(matrix.toString(), "Matrix:\n");
    }

    @Test
    public void createShouldReturnMatrixIfDimensionsAreValid() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        Matrix matrixA = Matrix.create(valuesA);
        assertEquals(true, matrixA instanceof Matrix);
    }

    @Test
    public void createShouldReturnNullIfDimensionsAreValid() {
        int[][] valuesA = {{1, 2}, {3}};
        Matrix matrixA = Matrix.create(valuesA);
        assertEquals(null, matrixA);
    }

    @Test
    public void shouldValidateIfMatrixAreEqual() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{1, 2}, {3, 4}};
        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        assertEquals(true, matrixA.equals(matrixB));
    }

    @Test
    public void shouldNotValidateIfOtherMatrixISNull() {
        int[][] valuesA = {{1, 2}, {3, 4}};

        Matrix matrixA = Matrix.create(valuesA);
        assertEquals(false, matrixA.equals(null));
    }

    @Test
    public void shouldNotValidateIfOtherIsNotAMatrix() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{1, 2}, {3, 4}};

        Matrix matrixA = Matrix.create(valuesA);
        assertEquals(false, matrixA.equals(valuesB));
    }

    @Test
    public void shouldNotValidateIfMatrixAreNotEqual() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{1, 2, 3}, {3, 4, 3}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        assertEquals(false, matrixA.equals(matrixB));
    }

    @Test
    public void addShouldAddTwoMatricesOfSameDimensions() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{2, 4}, {6, 8}};
        int[][] expectedValues = {{3, 6}, {9, 12}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        Matrix expectedMatrix = Matrix.create(expectedValues);

        assertEquals(expectedMatrix, matrixA.add(matrixB));
    }

    @Test
    public void addShouldReturnNullIfMatricesAreOfDifferentRowLength() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{2, 4}, {6, 8}, {10, 12}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);

        assertNull(matrixA.add(matrixB));
    }

    @Test
    public void addShouldReturnNullIfMatricesAreOfDifferentColumnLength() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{2, 4, 5}, {6, 8, 8}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);

        assertNull(matrixA.add(matrixB));
    }

    @Test
    public void subractShouldSubtractTwoMatricesOfSameDimensions() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{2, 4}, {6, 8}};
        int[][] expectedValues = {{1, 2}, {3, 4}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        Matrix expectedMatrix = Matrix.create(expectedValues);

        assertEquals(expectedMatrix, matrixB.subtract(matrixA));
    }

    @Test
    public void subtractShouldReturnNullIfMatricesAreOfDifferentDimensions() {
        int[][] valuesA = {{1, 2}, {3, 4}};
        int[][] valuesB = {{2, 4}, {6, 8}};
        int[][] expectedValues = {{1, 2}, {3, 4}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        Matrix expectedMatrix = Matrix.create(expectedValues);

        assertEquals(expectedMatrix, matrixB.subtract(matrixA));
    }

    @Test
    public void multiplyShouldMultiplyTwoValidMatrices() {
        int[][] valuesA = {{1, 2}};
        int[][] valuesB = {{2}, {4}};
        int[][] expectedValues = {{10}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);
        Matrix expectedMatrix = Matrix.create(expectedValues);

        assertEquals(expectedMatrix, matrixA.multiply(matrixB));
    }

    @Test
    public void multiplyShouldNotMultiplyTwoInvalidMatrices() {
        int[][] valuesA = {{1, 2}};
        int[][] valuesB = {{2}};

        Matrix matrixA = Matrix.create(valuesA);
        Matrix matrixB = Matrix.create(valuesB);

        assertNull(matrixA.multiply(matrixB));
    }

    @Test
    public void getDeterminantShouldReturnTheDeterminantofOneByOneMatrix() {
        int[][] values = {{1}};

        Matrix matrix = Matrix.create(values);

        assertEquals(1, matrix.getDeterminant());
    }

    @Test
    public void getDeterminantShouldReturnTheDeterminantOfTwoByTwoMatrix() {
        int[][] values = {{1, 2}, {2, 1}};

        Matrix matrix = Matrix.create(values);

        assertEquals(-3, matrix.getDeterminant());
    }

    @Test
    public void getDeterminantShouldReturnTheDeterminantOf3By3Matrix() {
        int[][] values = {{5, 4, 2}, {4, -3, 2}, {-1, -1, 1}};

        Matrix matrix = Matrix.create(values);

        assertEquals(-43, matrix.getDeterminant());
    }

    @Test
    public void getDeterminantShouldReturnTheDeterminantOf4By4Matrix() {
        int[][] values = {
                {1, 5, 2, -2},
                {4, 6, 0, -2},
                {0, 5, 1, 0},
                {2, 3, 5, -1},
        };

        Matrix matrix = Matrix.create(values);

        assertEquals(150, matrix.getDeterminant());
    }
}
