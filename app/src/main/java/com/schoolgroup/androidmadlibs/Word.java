package com.schoolgroup.androidmadlibs;

public class Word {
    private final WordType type;
    private String value;

    public Word(WordType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
