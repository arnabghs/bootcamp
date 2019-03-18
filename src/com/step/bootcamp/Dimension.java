package com.step.bootcamp;

public class Dimension {
  private Double value;

  public Dimension(Double value) throws Exception {
    validDimension(value);
    this.value = value;
  }

  private void validDimension(Double value) throws Exception {
    if (value < 0) {
      throw new MyException("Invalid dimensions");
    }
    return;
  }

  public Double getValue() {
    return this.value;
  }
}
