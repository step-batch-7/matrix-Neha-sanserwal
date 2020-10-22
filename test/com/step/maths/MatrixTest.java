package com.step.maths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    int[][] valuesC = { { 2 }, { 4 } };

    Matrix matrixA = Matrix.create(valuesA);
    Matrix matrixB = Matrix.create(valuesB);
    Matrix matrixC = Matrix.create(valuesC);
    assertTrue(matrixA.areDimensionsEqual(matrixB));
    assertFalse(matrixA.areDimensionsEqual(matrixC));
  }
}
