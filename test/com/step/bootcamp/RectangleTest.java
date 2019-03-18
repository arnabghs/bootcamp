package com.step.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleTest {
  @Test
  void shouldReturnAreaOfRectangle() throws Exception {
    Rectangle rectangle = new Rectangle(new Dimension(5D), new Dimension(10D));
    assertEquals(50, rectangle.calculateArea());
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
  void shouldReturnPerimeterOfGivenRectangle() throws Exception {
    Rectangle rectangle = new Rectangle(new Dimension(10D), new Dimension(5D));
    assertEquals(30, rectangle.calculatePerimeter());
  }
}