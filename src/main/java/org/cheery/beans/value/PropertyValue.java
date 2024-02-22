package org.cheery.beans.value;

public class PropertyValue {


    private final String name;

    private final Object value;

    // final的变量的constructor的模样
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
