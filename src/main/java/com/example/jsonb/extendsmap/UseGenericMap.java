package com.example.jsonb.extendsmap;

import java.util.Map;

public class UseGenericMap {
    Map<String, SomeDto> value;

    public Map<String, SomeDto> getValue() {
        return value;
    }

    public void setValue(Map<String, SomeDto> value) {
        this.value = value;
    }
}
