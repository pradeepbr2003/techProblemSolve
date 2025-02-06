package tech.logic.util;

public enum TechUtilEnum {
    MULTIPLY_TABLE("multiplicationTable"),
    APLHABETS("generateAlphbets"),
    PRIME("generatePrimeSeries"),
    FIBNOCCI("generateFibnocciSeries"),
    EMP_POPULATE("testEmployeePopulate");
    private String value;

    TechUtilEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
