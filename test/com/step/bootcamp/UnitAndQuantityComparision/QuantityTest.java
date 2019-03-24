package com.step.bootcamp.UnitAndQuantityComparision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

  @Test
  void shouldReturnTrueForValidComparisionForFeetAndInch() {
    Quantity feet = new Quantity(2, RatioUnit.FEET);
    Quantity inch = new Quantity(24, RatioUnit.INCH);
    assertEquals(feet, inch);
  }

  @Test
  void shouldReturnFalseForInvalidComparisionForFeetAndInch() {
    Quantity feet = new Quantity(1, RatioUnit.FEET);
    Quantity inch = new Quantity(24, RatioUnit.INCH);
    assertNotEquals(feet, inch);
  }

  @Test
  void shouldReturnTrueForValidComparisionForInchAndCentimeter() {
    Quantity inch = new Quantity(2, RatioUnit.INCH);
    Quantity centimeter = new Quantity(5, RatioUnit.CENTIMETER);
    assertEquals(inch, centimeter);
  }

  @Test
  void shouldReturnFalseForInvalidComparisionForInchAndCentimeter() {
    Quantity inch = new Quantity(2, RatioUnit.INCH);
    Quantity centimeter = new Quantity(6, RatioUnit.CENTIMETER);
    assertNotEquals(inch, centimeter);
  }

  @Test
  void shouldReturnTrueForValidComparisionForCentimeterAndMillimeter() {
    Quantity centimeter = new Quantity(6, RatioUnit.CENTIMETER);
    Quantity millimeter = new Quantity(60, RatioUnit.MILLIMETER);
    assertEquals(centimeter, millimeter);
  }

  @Test
  void shouldReturnFalseForInvalidComparisionForCentimeterAndMillimeter() {
    Quantity centimeter = new Quantity(6, RatioUnit.CENTIMETER);
    Quantity millimeter = new Quantity(50, RatioUnit.MILLIMETER);
    assertNotEquals(centimeter, millimeter);
  }

  @Test
  void shouldReturnTrueForValidComparisionForGallonAndLiters() {
    Quantity gallon = new Quantity(1, RatioUnit.GALLON);
    Quantity liters = new Quantity(3.78, RatioUnit.LITER);
    assertEquals(gallon, liters);
  }

  @Test
  void shouldReturnFalseForValidComparisionForGallonAndLiters() {
    Quantity gallon = new Quantity(1, RatioUnit.GALLON);
    Quantity liters = new Quantity(2.78, RatioUnit.LITER);
    assertNotEquals(gallon, liters);
  }

  @Test
  void shouldReturnFalseForDifferentTypesComparision() {
    Quantity liter = new Quantity(1, RatioUnit.LITER);
    Quantity centimeter = new Quantity(100, RatioUnit.CENTIMETER);
    assertNotEquals(liter, centimeter);
  }

  @Test
  void shouldAddTwoLengthsOfSameType() throws Exception {
    Quantity twoInches = new Quantity(2, RatioUnit.INCH);
    Quantity expectedSum = new Quantity(4, RatioUnit.INCH);
    Quantity actualSum = twoInches.add(twoInches);
    assertEquals(expectedSum, actualSum);
  }

  @Test
  void shouldThrowExceptionForAddingTwoLengthsOfDifferentType() {
    Quantity twoInches = new Quantity(2, RatioUnit.INCH);
    Quantity fourGallon = new Quantity(4, RatioUnit.GALLON);
    assertThrows(Exception.class, () -> twoInches.add(fourGallon));
  }

  @Test
  void shouldConvertToFirstTypeBeforeAddingIfTypesAreSameButUnitsAreDifferent() throws Exception {
    Quantity oneInches = new Quantity(1, RatioUnit.INCH);
    Quantity twentyFiveMm = new Quantity(25, RatioUnit.MILLIMETER);
    Quantity actualQuantity = oneInches.add(twentyFiveMm);
    Quantity expectedQuantity = new Quantity(2, RatioUnit.INCH);
    assertEquals(expectedQuantity, actualQuantity);
  }

  @Test
  void shouldConvertToFirstTypeBeforeAddingIfUnitsAreDifferent() throws Exception {
    Quantity oneInch = new Quantity(2, RatioUnit.INCH);
    Quantity twoPointFiveCm = new Quantity(2.5D, RatioUnit.CENTIMETER);
    Quantity actualQuantity = twoPointFiveCm.add(oneInch);
    Quantity expectedQuantity = new Quantity(3, RatioUnit.INCH);
    assertEquals(expectedQuantity, actualQuantity);
  }

  @Test
  void shouldAddOneFeetWithTwoInches() throws Exception {
    Quantity twoFeet = new Quantity(2, RatioUnit.FEET);
    Quantity twoInches = new Quantity(2, RatioUnit.INCH);
    Quantity actualQuantity = twoFeet.add(twoInches);
    Quantity expectedQuantity = new Quantity(26, RatioUnit.INCH);
    assertEquals(expectedQuantity, actualQuantity);
  }

  @Test
  void shouldAddOneGallonWithOneLiter() throws Exception {
    Quantity OneGallon = new Quantity(1, RatioUnit.GALLON);
    Quantity OneLiter = new Quantity(1, RatioUnit.LITER);
    Quantity actualQuantity = OneGallon.add(OneLiter);
    Quantity expectedQuantity = new Quantity(4.78, RatioUnit.LITER);
    assertEquals(expectedQuantity, actualQuantity);
  }

  @Test
  void ShouldReturnTrueIfGivenFahrenheitAndCelsiousAreEqual() {
    Quantity fahrenheit = new Quantity(212, ScaleUnit.FAHRENHEIT);
    Quantity celsius = new Quantity(100, ScaleUnit.CELSIUS);
    assertEquals(fahrenheit, celsius);
  }

  @Test
  void ShouldReturnFalseIfGivenFahrenheitAndCelsiousAreNotEqual() {
    Quantity fahrenheit = new Quantity(220, ScaleUnit.FAHRENHEIT);
    Quantity celsius = new Quantity(100, ScaleUnit.CELSIUS);
    assertNotEquals(fahrenheit, celsius);
  }

  @Test
  void ShouldNotAddTwoTemperatures() throws Exception {
    Quantity fahrenheit = new Quantity(212, ScaleUnit.FAHRENHEIT);
    Quantity celsius = new Quantity(100, ScaleUnit.CELSIUS);

    assertThrows(Exception.class, () -> fahrenheit.add(celsius));
  }
}
