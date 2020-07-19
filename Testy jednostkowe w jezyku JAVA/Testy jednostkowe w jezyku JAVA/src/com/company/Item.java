package com.company;

public class Item {
    private String value;
    private Item previous;

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws Exception {
        this.value = value;
    }

    public Item getPrevious() {
        return previous;
    }

    public void setPrevious(Item previous) {
        this.previous = previous;
    }
}
