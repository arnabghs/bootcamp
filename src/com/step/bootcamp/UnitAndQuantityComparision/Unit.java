package com.step.bootcamp.UnitAndQuantityComparision;

import java.util.HashMap;

class Unit {

  static final Unit MILLIMETER = new Unit(1, Type.LENGTH);
  static final Unit INCH = new Unit(25, Type.LENGTH);
  static final Unit FEET = new Unit(300, Type.LENGTH);
  static final Unit CENTIMETER = new Unit(10, Type.LENGTH);

  static final Unit LITER = new Unit(1, Type.VOLUME);
  static final Unit GALLON = new Unit(3.78, Type.VOLUME);

  private static HashMap<Type, Unit> standardUnit = new HashMap<>(2);

  static {
    standardUnit.put(Type.LENGTH, INCH);
    standardUnit.put(Type.VOLUME, LITER);
  }

  private final double ratio;
  private final Type type;

  private Unit(double ratio, Type type) {
    this.ratio = ratio;
    this.type = type;
  }

  Boolean isSameType(Unit unit) {
    return this.type == unit.type;
  }

  double convertToBaseValue(double value) {
    return this.ratio * value;
  }

  double convertValueTo(Unit unit, double value) {
    double conversionRatio = this.ratio / unit.ratio;
    return value * conversionRatio;
  }

  Unit getStandardUnit() {
    return standardUnit.get(this.type);
  }

  enum Type {
    LENGTH,
    VOLUME
  }
}