package com.step.bootcamp.UnitAndQuantityComparision;

import java.util.HashMap;

class RatioUnit extends Unit {

  static final RatioUnit MILLIMETER = new RatioUnit(1, Type.LENGTH);
  static final RatioUnit INCH = new RatioUnit(25, Type.LENGTH);
  static final RatioUnit FEET = new RatioUnit(300, Type.LENGTH);
  static final RatioUnit CENTIMETER = new RatioUnit(10, Type.LENGTH);


  static final RatioUnit LITER = new RatioUnit(1, Type.VOLUME);
  static final RatioUnit GALLON = new RatioUnit(3.78, Type.VOLUME);
  private static HashMap<Type, Unit> standardUnit = new HashMap<>(2);

  static {
    standardUnit.put(Type.LENGTH, INCH);
    standardUnit.put(Type.VOLUME, LITER);
  }

  private double ratio;
  private Type type;

  public RatioUnit(double ratio, Type type) {
    this.ratio = ratio;
    this.type = type;
  }

  @Override
  Boolean isSameType(Unit unit) {
    RatioUnit unit1 = (RatioUnit) unit;
    return this.type == unit1.type;
  }

  @Override
  double convertToBaseValue(double value) {
    return this.ratio * value;
  }

  @Override
  double convertValueTo(Unit unit, double value) {
    RatioUnit unit1 = (RatioUnit) unit;
    double conversionRatio = this.ratio / unit1.ratio;
    return value * conversionRatio;
  }

  @Override
  Unit getStandardUnit() {
    return standardUnit.get(this.type);
  }

  enum Type {
    LENGTH,
    VOLUME
  }
}
