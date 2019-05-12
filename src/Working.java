/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AbsoluteCrow
 */
public class Working {
    public static void main(String[] arg)
    {
        String pre_exp = "5 + ( 5 *  10 + ( 15 - 20 )  - 25 ) * 9"; 
        Arithmetic a = new Arithmetic(pre_exp);
        a.postfixExpression();
        System.out.println("Postfix: " + a.getPostfix());
    }
}
