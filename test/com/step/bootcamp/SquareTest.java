package com.step.bootcamp;

import com.step.bootcamp.dimension.Dimension;
import com.step.bootcamp.dimension.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SquareTest {
  @Test
  void shouldReturnAreaOfSquare() throws Exception {
    Square square = new Square(new Dimension(5D));
    assertEquals(25, square.calculateArea());
  }

  @Test
  void shouldReturnZeroForInvalidInputs() {

    boolean errorThrown = false;
    try {
      Dimension dimension = new Dimension(-1.0);
      dimension.getValue();
    } catch (Exception e) {
      errorThrown = true;
    }
    assertTrue(errorThrown);
  }

  @Test
  void shouldReturnPerimeterOfGivenSquare() throws Exception {
    Square square = new Square(new Dimension(10D));
    assertEquals(40, square.calculatePerimeter());
  }
}