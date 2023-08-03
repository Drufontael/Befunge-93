package aplication;

import befunge.Interpreter;
import befunge.Screen;

public class Program {
    public static void main(String[] args) {
        String helloWorld= """
                >              v
                v"Hello World!"<
                >:v
                ^,_@""";
        String sieve= """
                2>:3g" "-!v\\  g30          <
                 |!`"O":+1_:.:03p>03g+:"O"`|
                 @               ^  p3\\" ":<
                2 234567890123456789012345678901234567890123456789012345678901234567890123456789""";
        Screen test1=new Screen(sieve);
        Interpreter testUm=new Interpreter(test1);
        test1.printScreen();
        System.out.println(testUm.getPrint());
    }
}
