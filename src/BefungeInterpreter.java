
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BefungeInterpreter {

    public String interpret(String code) {
        Move move=new Move(">");
        Position position=new Position(0,0);
        String[] lines=code.split("(\n)");
        List<List<String>> commandScreen=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        StringBuilder print= new StringBuilder();
        int index=0;
        for (String line:lines){
            String[] commandLine=line.split("");
            commandScreen.add(new ArrayList<>());
            for(String c:commandLine){
                commandScreen.get(index).add(c);
            }
            index++;
        }
        while (position!=null){
            String command = commandScreen.get(position.getX()).get(position.getY());
            if (command.matches("[0-9]")) stack.push((int) command.charAt(0) - 48);
            else{
                int a;
                int b;
                int x;
                int y;
                int res;
                switch (command) {
                    case "<" -> move = new Move("<");
                    case ">" -> move = new Move(">");
                    case "^" -> move = new Move("^");
                    case "v" -> move = new Move("v");
                    case "?" -> move = new Move("?");
                    case "#" -> {
                        position.setX(position.getX() + move.getX());
                        position.setY(position.getY() + move.getY());
                    }
                    case "_" -> {
                        if (stack.pop() == 0) move = new Move(">");
                        else move = new Move("<");
                    }
                    case "|" -> {
                        if (stack.pop() == 0) move = new Move("v");
                        else move = new Move("^");
                    }
                    case "+" -> {
                        a = stack.pop();
                        b = stack.pop();
                        res = a + b;
                        stack.push(res);
                    }
                    case "-" -> {
                        a = stack.pop();
                        b = stack.pop();
                        res = b-a;
                        stack.push(res);
                    }
                    case "*" -> {
                        a = stack.pop();
                        b = stack.pop();
                        res = b * a;
                        stack.push(res);
                    }
                    case "/" -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a==0) stack.push(0);
                        else {
                            res = b / a;
                            stack.push(res);
                        }
                    }
                    case "%" -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a==0) stack.push(0);
                        else {
                            res = b % a;
                            stack.push(res);
                        }
                    }
                    case "!" -> {
                        a = stack.pop();
                        if (a==0) stack.push(1);
                        else stack.push(0);
                    }
                    case "`" -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a==0) stack.push(0);
                        else {
                            res = (a > b) ? 0 : 1;
                            stack.push(res);
                        }
                    }
                    case ":" -> {
                        if (stack.isEmpty()) {
                            stack.push(0);
                            stack.push(0);
                        }
                        else stack.push(stack.peek());
                    }
                    case "\\" -> {
                        a = stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(0);
                            stack.push(a);
                        } else {
                            b = stack.pop();
                            stack.push(a);
                            stack.push(b);
                        }
                    }
                    case "$" -> stack.pop();
                    case "." -> {
                        Integer integer = stack.pop();
                        print.append(integer);
                    }
                    case "," -> {
                        char character = (char) stack.pop().intValue();
                        print.append(character);
                    }
                    case "p" -> {
                        x = stack.pop();
                        y = stack.pop();
                        char v = (char) stack.pop().intValue();
                        commandScreen.get(x).set(y, v + "");
                    }
                    case "g" -> {
                        x = stack.pop();
                        y = stack.pop();
                        String vC = commandScreen.get(x).get(y);
                        stack.push((int) vC.charAt(0));
                    }
                    case "\"" -> {
                        do {
                            position.setX(position.getX() + move.getX());
                            position.setY(position.getY() + move.getY());
                            command = commandScreen.get(position.getX()).get(position.getY());
                            if (!command.equals("\"")) stack.push((int) command.charAt(0));
                        } while (!command.equals("\""));
                    }
                    case "@" -> position = null;
                }
            }
            if (position!=null)
            {
                position.setX(position.getX() + move.getX());
                position.setY(position.getY() + move.getY());
            }
        }

        return print.toString();
    }
}
