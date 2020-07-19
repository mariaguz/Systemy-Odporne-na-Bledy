package com.company;

import java.util.regex.Pattern;
import com.company.Priority.*;

import static com.company.Priority.getPriority;
import static com.company.Priority.priorityComparator;

public class OnpCalc  {

    static String infixToOnp(String infix) throws Exception {

        String regular = ".*\\/0([^.]|$|\\.(0{4,}.*|0{1,4}([^0-9]|$))).*";
        Pattern pattern = Pattern.compile(regular);
        if(pattern.matcher(infix).matches()){
            throw new Exception("DivideByZero");
        }

        StringBuilder onp = new StringBuilder();
        Stack stack = new Stack();

        StringBuilder nextCharacter;
        String character;
        PRIORITY characterPriority;

        while (!infix.isEmpty()) {
            character = infix.substring(0, 1);
            infix = infix.length() > 1 ? infix.substring(1) : "";

            characterPriority = getPriority(character);

            switch (characterPriority) {
                case VARIABLE:
                    nextCharacter = new StringBuilder(character);

                    if (!infix.isEmpty()) {
                        character = infix.substring(0, 1);

                        while (getPriority(character) == PRIORITY.VARIABLE) {
                            if (infix.length() > 1) {
                                infix = infix.substring(1);
                            }
                            else {
                                infix = "";
                            }
                            nextCharacter.append(character);
                            if (infix.isEmpty()) {
                                break;
                            }
                            character = infix.substring(0, 1);
                        }
                    }
                    onp.append("_").append(nextCharacter).append("_");
                    break;

                case PRIORITY_0:
                    stack.push(character);
                    character = infix.substring(0, 1);
                    if (character.equals("-")) {
                        stack.push("~");
                        infix = infix.substring(1);
                    }
                    break;

                case PRIORITY_1:
                case PRIORITY_2:
                case PRIORITY_3:
                    if (character.equals(")")) {
                        while (!stack.top().equals("(")) {
                            onp.append(stack.top());
                            stack.pop();
                        }
                        stack.pop();
                        break;
                    }
                    if ((onp.length() == 0) && character.equals("-")) {
                        stack.push("~");
                        break;
                    }
                    while (!stack.isEmpty()) {
                        if (priorityComparator(characterPriority, getPriority(stack.top()))) {
                            stack.push(character);
                            break;
                        } else {
                            onp.append(stack.top());
                            stack.pop();
                        }
                    }
                    if (stack.isEmpty())
                        stack.push(character);
                    break;
                default:
                    break;
            }
        }

        while (!stack.isEmpty()) {
            onp.append(stack.top());
            stack.pop();
        }

        return onp.toString();
    }

    public static String calculateOnp(String onp) throws Exception {
        onp = onp+"|";
        Stack stack = new Stack();
        float out, temp;
        StringBuilder tempString;
        String character = onp.substring(0, 1);
        onp = onp.substring(1);

        while (!character.equals("|")) {
            tempString = new StringBuilder();
            switch (character) {
                case "_":
                    character = onp.substring(0, 1);
                    onp = onp.substring(1);
                    do {
                        tempString.append(character);
                        character = onp.substring(0, 1);
                        onp = onp.substring(1);
                    } while (!character.equals("_"));
                    stack.push(tempString.toString());
                    break;
                case "+":
                    temp = Float.parseFloat(stack.pop());
                    out = Float.parseFloat(stack.pop()) + temp;
                    stack.push(out+"");
                    break;
                case "-":
                    temp = Float.parseFloat(stack.pop());
                    out = Float.parseFloat(stack.pop()) - temp;
                    stack.push(out+"");
                    break;
                case "~":
                    out = -Float.parseFloat(stack.pop());
                    stack.push(out+"");
                    break;
                case "*":
                    temp = Float.parseFloat(stack.pop());
                    out = Float.parseFloat(stack.pop()) * temp;
                    stack.push(out+"");
                    break;
                case "/":
                    temp = Float.parseFloat(stack.pop());
                    if (temp == 0) {
                        throw new Exception("You can not divide by zero");
                    }
                    out = Float.parseFloat(stack.pop()) / temp;
                    stack.push(out+"");
                    break;
                case "%":
                    temp = Float.parseFloat(stack.pop());
                    out = Float.parseFloat(stack.pop()) % temp;
                    stack.push(out+"");
                    break;
                case "^":
                    temp = Float.parseFloat(stack.pop());
                    out = (float) Math.pow(Float.parseFloat(stack.pop()), temp);
                    stack.push(out+"");
                    break;
            }
            character = onp.substring(0, 1);
            if (onp.length() > 1)
                onp = onp.substring(1);
            else
                onp = "";
        }

        return stack.top();
    }
}
