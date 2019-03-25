package com.coding.temp.utils;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Xyang Song
 */
public enum Key {
    OK("0000"),
    ERROR("9999"),;

    private final String code;

    Key(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}