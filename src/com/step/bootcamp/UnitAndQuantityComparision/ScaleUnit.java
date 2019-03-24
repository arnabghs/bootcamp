package com.step.bootcamp.UnitAndQuantityComparision;

import java.util.HashMap;

class ScaleUnit extends Unit {
  static final ScaleUnit FAHRENHEIT = new ScaleUnit(1, Type.TEMPERATURE, 0);
  static final ScaleUnit CELSIUS = new ScaleUnit(1.8, Type.TEMPERATURE, 32);
  private static HashMap<Type, Unit> standardUnit = new HashMap<>();

  static {
    standardUnit.put(Type.TEMPERATURE, FAHRENHEIT);
  }

  private double ratio;
  private Type type;
  private double scale;

  public ScaleUnit(double ratio, Type type, double scale) {
    this.ratio = ratio;
    this.type = type;
    this.scale = scale;
  }

  @Override
  Boolean isSameType(Unit unit) {
    ScaleUnit unit1 = (ScaleUnit) unit;
    return this.type == unit1.type;
  }

  @Override
  double convertToBaseValue(double value) {
    return (this.ratio * value) + this.scale;
  }

  @Override
  double convertValueTo(Unit unit, double value) {
    ScaleUnit unit1 = (ScaleUnit) unit;
    double conversionRatio = this.ratio / unit1.ratio;
    return (value * conversionRatio) + this.scale;
  }

  @Override
  Unit getStandardUnit() {
    return standardUnit.get(this.type);
  }

  enum Type {
    TEMPERATURE
  }
}
