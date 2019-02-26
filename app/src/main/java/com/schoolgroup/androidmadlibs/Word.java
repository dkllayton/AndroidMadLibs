package com.schoolgroup.androidmadlibs;

public class Word {
    private final String type;
    private String value;

    public Word(String type) {
        this.type = type;
    }

    public String getType() { return type; }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
