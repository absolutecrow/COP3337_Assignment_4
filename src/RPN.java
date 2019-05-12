/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class RPN {
    public static void main(String[] arg)
	{
            String s[] = {"5 + ) * ( 2",
                                  " 2 + ( - 3 * 5 ) ",
                          "(( 2 + 3 ) * 5 ) * 8 ",
                          "5 * 10 + ( 15 - 20 ) )  - 25",
                          " 5 + ( 5 *  10 + ( 15 - 20 )  - 25 ) * 9"
                         };
            for (int i = 0; i < s.length; i++)
            {
                Arithmetic a = new Arithmetic(s[i]);
                if (a.isBalance())
                {
                    System.out.println("Expression " + s[i] + " is balanced");
                    a.postfixExpression();
                    System.out.println("The post fixed expression is " + a.getPostfix() + "\n");
                    //a.evaluateRPN();
                }
                else
                    System.out.println("Expression " + s[i] + " is not balanced\n");
            }
	}
}
