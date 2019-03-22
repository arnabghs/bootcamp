package com.step.bootcamp.UnitAndQuantityComparision;

class Quantity {
  private Unit unit;
  private double value;

  Quantity(double value, Unit unit) {
    this.unit = unit;
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Quantity)) return false;
    Unit quantityUnit = ((Quantity) o).unit;
    double quantityValue = ((Quantity) o).value;
    if (!quantityUnit.isSameType(this.unit)) return false;
    double thisBaseValue = this.unit.convertToBaseValue(this.value);
    double quantityBaseValue = quantityUnit.convertToBaseValue(quantityValue);
    return Math.floor(thisBaseValue) == Math.floor(quantityBaseValue);
  }

  Quantity add(Quantity quantity) throws Exception {
    if (!quantity.unit.isSameType(this.unit)) {
      throw new Exception("type is not same");
    }

    Unit standardUnit = this.unit.getStandardUnit();
    double thisQuantityValue = this.unit.convertValueTo(standardUnit, this.value);
    Quantity thisQuantity =  new Quantity(thisQuantityValue, standardUnit);
    double anotherQuantityValue = quantity.unit.convertValueTo(standardUnit, quantity.value);
    Quantity anotherQuantity = new Quantity(anotherQuantityValue, standardUnit);
    double valueInStandardUnit = thisQuantity.value + anotherQuantity.value;
    return new Quantity(valueInStandardUnit, standardUnit);
  }
}