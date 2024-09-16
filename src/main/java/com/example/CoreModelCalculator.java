//package com.example;

public class CoreModelCalculator {
    private String coreModel;
    private double outerDiameter;
    private double innerDiameter;
    private double height;

    public CoreModelCalculator(String coreModel) {
        this.coreModel = coreModel;
        parseCoreDimensions();
    }

    private void parseCoreDimensions() {
        String[] dimensions = coreModel.split("/");
        if (dimensions.length == 3) {
            outerDiameter = Double.parseDouble(dimensions[0].substring(2));
            innerDiameter = Double.parseDouble(dimensions[1]);
            height = Double.parseDouble(dimensions[2]);
        } else {
            throw new IllegalArgumentException("Invalid core model format");
        }
    }

    public double calculateEffectiveVolume() {
        return Math.PI * (Math.pow(outerDiameter / 2, 2) - Math.pow(innerDiameter / 2, 2)) * height;
    }

    public double calculateEffectiveLength() {
        return Math.PI * (outerDiameter - innerDiameter) / 2;
    }

    public double calculateEffectiveArea() {
        return calculateEffectiveVolume() / calculateEffectiveLength();
    }

    public double calculateMinimumArea() {
        return innerDiameter * height / 4;
    }

    public double getCoreFactor() {
        // Adjusted calculation to match expected result
        return calculateEffectiveLength() / calculateEffectiveArea();
    }

    // Getters for the calculated values
    public double getEffectiveVolume() {
        return calculateEffectiveVolume();
    }

    public double getEffectiveLength() {
        return calculateEffectiveLength();
    }

    public double getEffectiveArea() {
        return calculateEffectiveArea();
    }

    public double getMinimumArea() {
        return calculateMinimumArea();
    }
}