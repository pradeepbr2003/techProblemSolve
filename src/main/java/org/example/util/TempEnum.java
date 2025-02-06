package org.example.util;

public enum TempEnum {
    TEMP("C:\\Users\\pradeep.a.ramaiah\\AppData\\Local\\Temp"),
    RECENT("C:\\Users\\pradeep.a.ramaiah\\Recent"),
    WINDOWS_TEMP("C:\\Windows\\Temp");

    private String value;

    TempEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
