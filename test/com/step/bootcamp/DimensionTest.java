package com.step.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DimensionTest {
  @Test
  void shouldReturnValidDimension() throws Exception {
    Dimension dimension1 = new Dimension(5.0D);
    assertEquals(5, dimension1.getValue());
  }

  @Test
  void shouldReturnErrorForInvalidDimension() {
    Assertions.assertThrows(MyException.class, () -> new Dimension(-5.0D));
  }
}
