package com.optiva.charging.openapi.internal;

public class DummyAccountBalance {
    private String unit;
    private String type;
    private double value;

    public String getUnit() {
        return unit;
    }

    public DummyAccountBalance setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public double getValue() {
        return value;
    }

    public DummyAccountBalance setValue(double value) {
        this.value = value;
        return this;
    }

    public String getType() {
        return type;
    }

    public DummyAccountBalance setType(String type) {
        this.type = type;
        return this;
    }
}
