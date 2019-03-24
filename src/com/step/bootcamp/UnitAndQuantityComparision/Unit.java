package com.step.bootcamp.UnitAndQuantityComparision;

abstract class Unit {
  abstract Boolean isSameType(Unit unit);
  abstract double convertToBaseValue(double value);
  abstract double convertValueTo(Unit unit, double value);
  abstract Unit getStandardUnit();
}