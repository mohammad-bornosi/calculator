package org.mohh;

import java.util.Stack;

public class Postfixnotation {
    Stack<String>stack_output=new Stack<>();
    Stack<String>reverse_stack_output=new Stack<>();
    Stack<String>stack_javab=new Stack<>();
    String []operator={"+","-","*","/","^"};
    public Postfixnotation(Stack<String> stac_output) {
        this.stack_output = stac_output;
    }
    public String answer(){
        while(!stack_output.empty()){
            reverse_stack_output.push(stack_output.pop());
        }
        while(!reverse_stack_output.empty()){
            String number1;
            String number2;
            String result;
            String result1="";
            result=reverse_stack_output.pop();
            if(result.charAt(0)>='0'&&result.charAt(0)<='9'){
                stack_javab.push(result);
                continue;
            }

            else if(result.equalsIgnoreCase("cos")||result.equalsIgnoreCase("sin")){
                if(result.equalsIgnoreCase("cos")){
                    stack_javab.push(String.valueOf(Math.cos(Double.parseDouble(stack_javab.pop()))));
                }
                else if(result.equalsIgnoreCase("sin")){
                    stack_javab.push(String.valueOf(Math.sin(Double.parseDouble(stack_javab.pop()))));
                }
            }
            for (int j = 0; j <operator.length ; j++) {
                if(result.equalsIgnoreCase(operator[j])){
                    number2=stack_javab.pop();
                    number1=stack_javab.pop();
                    if(result.equalsIgnoreCase("+")) {
                        result1 = String.valueOf(Double.parseDouble(number1) + Double.parseDouble(number2));
                    } else if(result.equalsIgnoreCase("*"))
                        result1=String.valueOf(Double.parseDouble(number1)*Double.parseDouble(number2));
                    else if(result.equalsIgnoreCase("^"))
                        result1=String.valueOf(Math.pow(Double.parseDouble(number1),(Double.parseDouble(number2))));
                    else if(result.equalsIgnoreCase("/"))
                        result1=String.valueOf((Double.parseDouble(number1)/Double.parseDouble(number2)));
                    else if(result.equalsIgnoreCase("-"))
                    result1=String.valueOf((Double.parseDouble(number1)-Double.parseDouble(number2)));
                    stack_javab.push(result1);
                }
            }
        }
        return stack_javab.lastElement();
    }
}