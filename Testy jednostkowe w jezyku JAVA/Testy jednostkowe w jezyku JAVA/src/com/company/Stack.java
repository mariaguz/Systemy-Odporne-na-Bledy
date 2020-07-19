package com.company;

public class Stack {
    private Item top;

    public Stack() {
        top = null;
    }

    public String top() throws Exception  {
        if(isEmpty()) {
            throw new Exception("Stack is empty.");
        }
        return top.getValue();
    }

    public String pop() throws Exception  {
        if(isEmpty()) {
            throw new Exception("Stack is empty.");
        }

        String ret = top.getValue();
        top = top.getPrevious();

        return ret;
    }

    public void push(String value) throws Exception {
        Item newItem = new Item();

        try {
            newItem.setValue(value);
        } catch (Exception e) {
            throw new Exception(e);
        }

        if(isEmpty()){
            top = newItem;
            top.setPrevious(null);
        } else {
            newItem.setPrevious(top);
            top = newItem;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}
