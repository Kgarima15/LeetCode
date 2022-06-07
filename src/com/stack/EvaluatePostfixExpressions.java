package com.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class EvaluatePostfixExpressions {
    public static void main(String[] args) {
        String[] tokens = new String[]{"6", "3", "2", "+", "*", "5", "/"};
        int len = tokens.length;
        HashSet<String> set = new HashSet<String>(Arrays.asList("+", "-", "/", "*"));

        Stack<String> stack = new Stack<>();

        int i = 0;
        while(i<len) {
            if(set.contains(tokens[i])) {
                var operand2 = stack.pop();
                var operand1 = stack.pop();
                int result = getResult(tokens[i], operand1, operand2);
                stack.push(String.valueOf(result));

            }
            else {
                stack.push(tokens[i]);
            }
            i++;
        }
        System.out.println(stack.pop());
    }

    static int getResult(String token, String op1, String op2){
        int operand1 = Integer.parseInt(op1);
        int operand2 = Integer.parseInt(op2);
        if(token == "+")
            return operand1+operand2;
        if(token == "-")
            return operand1-operand2;
        if(token == "/")
            return operand1/operand2;
        else return operand1*operand2;
    }
}
