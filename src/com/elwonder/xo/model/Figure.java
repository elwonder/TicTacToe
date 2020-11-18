package com.elwonder.xo.model;

public enum Figure {
    X("X"), O("O");

    private final String value;

    public String getValue() {
        return value;
    }

    Figure(String value) {
        this.value = value;
    }
}