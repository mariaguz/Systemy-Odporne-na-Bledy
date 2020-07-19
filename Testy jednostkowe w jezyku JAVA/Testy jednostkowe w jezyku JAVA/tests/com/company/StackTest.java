package com.company;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    // PUNKT 1; 3 testy
    @Test
    public void test_whenStackIsNotUsed_givenNewStack_thenIsEmptyReturnTrue() {
        //given
        Stack stack = new Stack();

        //when
        //stack not used

        //then
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_whenStackIsNotUsed_givenNewStack_thenTopMethodThrowException() {
        //given
        Stack stack = new Stack();

        //when
        //stack not used

        //then
        assertThrows(Exception.class, () -> {
            stack.top();
        });
    }

    @Test
    public void test_whenStackIsNotUsed_givenNewStack_thenPopMethodThrowException() {
        //given
        Stack stack = new Stack();

        //when
        //stack not used

        //then
        assertThrows(Exception.class, () -> {
            stack.pop();
        });
    }

    //Punkt 2; 2 testy
    @Test
    public void test_whenPushValueOnStack_givenStack_thenShouldReturnPushedValue() throws Exception {
        //given
        Stack stack = new Stack();
        String[] testValues = new String[]{"1", "2", "*", "3", "+"};

        for(String str : testValues){
            //when
            stack.push(str);
            //then
            assertEquals(stack.top(), str);
        }
    }

    @Test
    public void test_whenPushValueOnStack_givenStack_thenShouldNotBeEmpty() throws Exception {
        //given
        Stack stack = new Stack();
        String[] testValues = new String[]{"1", "2", "*", "3", "+"};

        //when
        for(String str : testValues){
            stack.push(str);
        }

        //then
        assertFalse(stack.isEmpty());
    }

    //Punkt 3; 3 testy
    @Test
    public void test_whenPushValueOnStack_givenStack_thenShouldReturnSameValue() throws Exception {
        //given
        Stack stack = new Stack();
        String value = "0";

        //when
        stack.push(value);

        //then
        assertSame(stack.pop(), value);
    }

    @Test
    public void test_whenPushAndPopValueOnStack_givenStack_thenShouldBeEmpty() throws Exception {
        //given
        Stack stack = new Stack();
        String value = "0";

        //when
        stack.push(value);
        stack.pop();

        //then
        assertTrue(stack.isEmpty());
    }

    @Test
    public void test_whenPushAndPopValueOnStack_givenStack_thenPopShouldThrowException() throws Exception {
        //given
        Stack stack = new Stack();
        String value = "0";

        //when
        stack.push(value);
        stack.pop();

        //then
        assertThrows(Exception.class, () -> {
            stack.pop();
        });
    }

    //Punkt 4; 1 test
    @Test
    public void test_whenPushValuesOnStack_givenStack_thenShouldReturnValuesReversOrderNext() throws Exception {
        //given
        Stack stack = new Stack();

        //when
        String[] testValues = new String[]{"1", "2", "*", "3", "+"};
        for(String str : testValues){
            stack.push(str);
        }

        //then
        for(int i = testValues.length - 1; i>=0; --i){
            assertSame(stack.pop(), testValues[i]);
        }
    }

    //PUNKT 5; 1 test
    @Test
    public void test_whenPushNullValue_givenStack_thenShouldReturnNullValue() throws Exception {
        //given
        Stack stack = new Stack();

        //when
        stack.push(null);

        //then
        assertNull(stack.top());
    }

    //PUNKT 6; 1 test
    @Test
    public void test_whenStackThrowEception_gienStack_thenStackShouldWorkCorrectly() throws Exception{
        //given
        Stack stack = new Stack();

        //when
        try {
            stack.top();
        } catch (Exception e) {
            e.printStackTrace();
        }
        stack.push("1");

        //then
        assertEquals(stack.top(), "1");
    }
}