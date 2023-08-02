package aplication;

import befunge.Interpreter;
import befunge.Screen;

public class Program {
    public static void main(String[] args) {
        String helloWorld=">              v\nv\"Hello World!\"<\n"
                +">:v\n^,_@";
        String sieve="2>:3g\" \"-!v\\  g30          <\n |!`\"O\":+1_:.:03p>03g+:\"O\"`|\n"
                +" @               ^  p3\\\" \":<\n"
                +"2 234567890123456789012345678901234567890123456789012345678901234567890123456789";
        Screen test1=new Screen(helloWorld);
        Interpreter testUm=new Interpreter(test1);
        System.out.println(testUm.getPrint());
    }
}
