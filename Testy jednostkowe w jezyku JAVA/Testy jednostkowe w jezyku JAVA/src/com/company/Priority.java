package com.company;

public class Priority {

    public enum PRIORITY {
        PRIORITY_0,
        PRIORITY_1,
        PRIORITY_2,
        PRIORITY_3,
        VARIABLE,
    }

    static boolean priorityComparator(PRIORITY priority1, PRIORITY priority2) {
        boolean ret = false;

        switch (priority1) {
            case PRIORITY_0:
                ret = false;
            case PRIORITY_1:
                if(priority2 == PRIORITY.PRIORITY_0){
                    ret = true;
                }
                break;
            case PRIORITY_2:
                if(priority2 == PRIORITY.PRIORITY_0 || priority2 == PRIORITY.PRIORITY_1){
                    ret = true;
                }
                break;
            case PRIORITY_3:
                if(priority2 == PRIORITY.PRIORITY_0 || priority2 == PRIORITY.PRIORITY_1 || priority2 == PRIORITY.PRIORITY_2){
                    ret = true;
                }
                break;
            default:
                ret = true;
                break;
        }
        return ret;
    }

    static PRIORITY getPriority(String symbol) {
        PRIORITY priority = null;
        switch (symbol) {

            case "(":
                priority = PRIORITY.PRIORITY_0;
                break;

            case "-": case "+": case ")":
                priority = PRIORITY.PRIORITY_1;
                break;

            case "~": case "*": case "/": case "%":
                priority = PRIORITY.PRIORITY_2;
                break;

            case "^":
                priority = PRIORITY.PRIORITY_3;
                break;

            default:
                priority = PRIORITY.VARIABLE;
                break;
        }

        return priority;
    }
}
