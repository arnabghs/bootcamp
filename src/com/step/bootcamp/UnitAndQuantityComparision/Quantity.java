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
    double baseValue = this.unit.convertToBaseValue(this.value);
    return baseValue == quantityUnit.convertToBaseValue(quantityValue);
  }

  Quantity add(Quantity quantity) throws Exception {
    if (!quantity.unit.isSameType(this.unit)) {
      throw new Exception("type is not same");
    }
    double quantityBaseValue = quantity.unit.convertToBaseValue(quantity.value);
    double ownBaseValue = this.unit.convertToBaseValue(this.value);
    double sum = (ownBaseValue + quantityBaseValue) / this.unit.getRatio();
    return new Quantity(sum, this.unit);
  }
}