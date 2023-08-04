package aplication;

import befunge.Interpreter;
import befunge.Screen;
import exceptions.BefungeException;

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
        String quebrada="$";

        try {
            Screen test1 = new Screen(">g");
            Interpreter testUm = new Interpreter(test1);
            test1.printScreen();
            System.err.println(testUm.getPrint());
        }catch (BefungeException e){
            System.err.println("Execution failure: "+e.getMessage());
        }
    }
}
