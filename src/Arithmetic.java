
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class Arithmetic {
    
    String expression, postfix;
    int length;
    Stack<Character> stk;
    
    Arithmetic(String s)
        {
            expression = s;
            expression = expression.replaceAll("\\s+", "");
            postfix = "";
            length = expression.length();
            stk = new Stack();
        }
    
    void postfixExpression()
    {
        stk.clear();
        
        for (int i = 0; i < length; i++)
        {
            char currentChar = expression.charAt(i);
            
            if (isNumber(currentChar))
                postfix += currentChar;
            else if(currentChar == '(')
                stk.push(currentChar);
            else if(currentChar == ')')
            {
                while (!stk.isEmpty() && stk.peek() != '(')
                    postfix += stk.pop();                
            }
            else
            {
                while (!stk.isEmpty() && hasHigherPrecedence(currentChar) <= hasHigherPrecedence(stk.peek()))
                    postfix += stk.pop();
                stk.push(currentChar);
            }
        }
        
        while (!stk.isEmpty())
        {
            if (stk.peek() == '(')
                stk.pop();
            else
                postfix += stk.pop();
        }
    }
    
    void evaluateRPN() {
        
        Scanner scanner = new Scanner(expression);
        
        Stack operands = new Stack();
        
        while (scanner.hasNext()) {
            
            if (scanner.hasNextDouble()) {
                operands.push(scanner.nextDouble());
            }
            else {
                double operand2 = (double) operands.pop();
                double operand1 = (double) operands.pop();
                String operator = scanner.next();
                
                switch (operator) {
                case "+" : operands.push(operand1 + operand2); break;
                case "-" : operands.push(operand1 - operand2); break;
                case "*" : operands.push(operand1 * operand2); break;
                case "/" : operands.push(operand1 / operand2); break;
                case "^" : operands.push(Math.pow(operand1, operand2)); break;
                }
            }
        }
        
        scanner.close();
        System.out.println(operands.pop());
    }
    
    boolean isBalance()
    {
        int index = 0;
        boolean fail = false;		
        try
        {
                while (index < length && !fail)
                {
                        char ch = expression.charAt(index);
                        switch (ch) 
                        {
                                case '(':
                                        stk.push(new Character(ch));
                                break;
                                case ')':
                                        stk.pop();
                                break;
                                default:

                                break;
                        }//end of swtich
                        index++;
                }//end of while
        }//end of try
        catch (EmptyStackException e) 
        {
                System.out.println("Unable to convert to postfix."); 
                fail = true;
        }
        if (stk.empty() && !fail)
                return true;
        else
                return false;
    }
    
    String getPostfix()
    { 
        return postfix;
        //return postfix.replace("", " ").trim();
    }
    
    boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%';
    }
    
    boolean isNumber(char ch)
    {
        return Character.isDigit(ch);
    }

    boolean isParentheses(char ch)
    {
        return ch == '(' || ch == ')';
    }
    
    int hasHigherPrecedence(char ch)
    {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }
}
