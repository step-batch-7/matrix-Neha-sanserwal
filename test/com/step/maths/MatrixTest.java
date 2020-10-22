package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class MatrixTest {

  @Test
  public void shouldReturnTextualFromOfMatrix() {
    Matrix matrix = new Matrix(0, 0);
    assertEquals(matrix.toString(), "Matrix:\n");
  }

  @Test
  public void shouldValidateIfDimensionsOfMatrixAreEqual() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2, 3 }, { 4, 5 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    assertTrue(matrixA.areDimensionsEqual(matrixB));
  }

  @Test
  public void shouldValidateIfDimensionsOfMatrixAreNotEqual() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2 }, { 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    assertFalse(matrixA.areDimensionsEqual(matrixB));
  }

  @Test
  public void shouldValidateIfMatrixAreEqual() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 1, 2 }, { 3, 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    assertTrue(matrixA.equals(matrixB));
  }

  @Test
  public void shouldNotValidateIfOtherMatrixISNull() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    assertFalse(matrixA.equals(null));
  }

  @Test
  public void shouldNotValidateIfOtherIsNotAMatrix() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 1, 2 }, { 3, 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    assertFalse(matrixA.equals(valuesB));
  }

  @Test
  public void shouldNotValidateIfMatrixAreNotEqual() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 1, 2, 3 }, { 3, 4, 3 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    assertFalse(matrixA.equals(matrixB));
  }

  @Test
  public void shouldAddTwoMatricesOfSameDimensions() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2, 4 }, { 6, 8 } };
    int[][] expectedValues = { { 3, 6 }, { 9, 12 } };
    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    Matrix expectedMatrix = Matrix.create(expectedValues);

    assertEquals(expectedMatrix, matrixA.add(matrixB));
  }

  @Test
  public void addShouldReturnNullIfMatricesAreOfDifferentDimensions() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2, 4, 5 }, { 6, 8, 8 } };
    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    assertNull(matrixA.add(matrixB));
  }

  @Test
  public void shouldSubtractTwoMatricesOfSameDimensions() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2, 4 }, { 6, 8 } };
    int[][] expectedValues = { { 1, 2 }, { 3, 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    Matrix expectedMatrix = Matrix.create(expectedValues);

    assertEquals(expectedMatrix, matrixB.subtract(matrixA));
  }

  @Test
  public void subtractShouldReturnNullIfMatricesAreOfDifferentDimensions() {
    int[][] valuesA = { { 1, 2 }, { 3, 4 } };
    int[][] valuesB = { { 2, 4 }, { 6, 8 } };
    int[][] expectedValues = { { 1, 2 }, { 3, 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    Matrix expectedMatrix = Matrix.create(expectedValues);

    assertEquals(expectedMatrix, matrixB.subtract(matrixA));
  }
}
