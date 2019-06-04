package org.mohh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Shungtinyard {
    String[] operator1 = {"+", "-", "*", "/", "^"};
    static HashMap<String, Integer> operator = new HashMap<String, Integer>();

    static{
        operator.put("+", 1);
        operator.put("-", 1);
        operator.put("*", 2);
        operator.put("/", 2);
        operator.put("^", 3);
    }

    List<String> moadele = new ArrayList<>();
    Stack<String> stack_output = new Stack<>();
    Stack<String> stack_operator = new Stack<>();

    public Shungtinyard(List<String> modele) {
        this.moadele = modele;
    }

    public String fiil_stack_output() {
        for (int i = 0; i < moadele.size(); i++) {
            for (int j = 0; j < operator1.length; j++) {
                if (moadele.get(i).equalsIgnoreCase(operator1[j])) {
                    if (!stack_operator.isEmpty()) {
                        while (
                                (!stack_operator.lastElement().equalsIgnoreCase("(")) &&
                                (
                                        (stack_operator.lastElement().equalsIgnoreCase("cos") || stack_operator.lastElement().equalsIgnoreCase("sin"))
                                        || (operator.get(stack_operator.lastElement()) == operator.get(operator1[j]) && !(operator1[j]).equalsIgnoreCase("^"))
                                        || (operator.get(String.valueOf(stack_operator.lastElement()).trim())) > operator.get(operator1[j])
                                )
                        ) {
                            System.out.println(operator.get(String.valueOf(stack_operator.lastElement()).trim()));
                            stack_output.push(stack_operator.pop());
                            if (stack_operator.isEmpty()) {
                                break;
                            }
                        }
                    }
                    stack_operator.push(operator1[j]);
                }
            }
            if (moadele.get(i).equalsIgnoreCase("sin") || moadele.get(i).equalsIgnoreCase("cos")) {
                stack_operator.push(moadele.get(i));
            } else if (moadele.get(i).charAt(0) >= '0' && moadele.get(i).charAt(0) <= '9') {
                String number = moadele.get(i);
                int j = i + 1;
                if (j < moadele.size()) {
                    for (j = i + 1; (moadele.get(j).charAt(0) >= '0' && moadele.get(j).charAt(0) <= '9') || moadele.get(j).equalsIgnoreCase("."); j++) {
                        number = number + moadele.get(j);
                        if (j >= moadele.size()) {
                            break;
                        }
                    }
                }
                stack_output.push(number);
                i = j - 1;
            } else if (moadele.get(i).equalsIgnoreCase("(")) {
                stack_operator.push("(");
            } else if (moadele.get(i).equalsIgnoreCase(")")) {
                while (!stack_operator.lastElement().equalsIgnoreCase("(")) {
                    stack_output.push(stack_operator.lastElement());
                    stack_operator.pop();
                }
                stack_operator.pop();
            }
        }
        while (!stack_operator.isEmpty()) {
            stack_output.push(stack_operator.pop());
        }
        Postfixnotation postfixnotation = new Postfixnotation(stack_output);
        return postfixnotation.answer();
    }
}