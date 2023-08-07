package befunge;

import exceptions.BefungeException;

import java.util.Stack;

public class Interpreter extends Screen{

    private final StringBuilder print = new StringBuilder();
    private final Stack<Integer> stack = new Stack<>();

    public Interpreter(String commandScreen) {
        super(commandScreen);
        setPrint();
    }

    public String getPrint() {
        return print.toString();
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    private void setPrint() {
        int a, b, x, y, v;
        while (pointer != null) {
            char command = super.command(pointer);
            if (command>='0' && command <= '9') stack.push((int) command - 48);
            else {
                switch (command) {
                    case '<' -> direction.setCommand('<');
                    case '>' -> direction.setCommand('>');
                    case '^' -> direction.setCommand('^');
                    case 'v' -> direction.setCommand('v');
                    case '?' -> direction.setCommand('?');
                    case '#' -> pointer.moveTo(direction);
                    case '_' -> {
                        if (stack.pop() == 0) direction.setCommand('>');
                        else direction.setCommand('<');
                    }
                    case '|' -> {
                        if (stack.pop() == 0) direction.setCommand('v');
                        else direction.setCommand('^');
                    }
                    case '+' -> {
                        a = stack.pop();
                        b = stack.pop();
                        v = a + b;
                        stack.push(v);
                    }
                    case '-' -> {
                        a = stack.pop();
                        b = stack.pop();
                        v = b - a;
                        stack.push(v);
                    }
                    case '*' -> {
                        a = stack.pop();
                        b = stack.pop();
                        v = b * a;
                        stack.push(v);
                    }
                    case '/' -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a == 0) stack.push(0);
                        else {
                            v = b / a;
                            stack.push(v);
                        }
                    }
                    case '%' -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a == 0) stack.push(0);
                        else {
                            v = b % a;
                            stack.push(v);
                        }
                    }
                    case '!' -> {
                        a = stack.pop();
                        if (a == 0) stack.push(1);
                        else stack.push(0);
                    }
                    case '`' -> {
                        a = stack.pop();
                        b = stack.pop();
                        if (a == 0) stack.push(0);
                        else {
                            v = (a > b) ? 0 : 1;
                            stack.push(v);
                        }
                    }
                    case ':' -> {
                        if (stack.isEmpty()) {
                            stack.push(0);
                            stack.push(0);
                        } else stack.push(stack.peek());
                    }
                    case '\\' -> {
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
                    case '$' -> {
                        if(stack.isEmpty()) throw new BefungeException("Stack is empty, unable to execute '$'");
                        stack.pop();
                    }
                    case '.' -> {
                        Integer integer = stack.pop();
                        print.append(integer);
                    }
                    case ',' -> {
                        char character = (char) stack.pop().intValue();
                        print.append(character);
                    }
                    case 'p' -> {
                        if(stack.size()<3) throw new BefungeException("Unable to execute 'p'");
                        x = stack.pop();
                        y = stack.pop();
                        v = stack.pop();
                        super.modify(x, y, v);
                    }
                    case 'g' -> {
                        if(stack.size()<2) throw new BefungeException("Unable to execute 'g'");
                        x = stack.pop();
                        y = stack.pop();
                        char vC = super.command(new Pointer(x, y));
                        stack.push((int) vC);
                    }
                    case '\"' -> {
                        do {
                            pointer.moveTo(direction);
                            command = super.command(pointer);
                            if (command != '\"') stack.push((int) command);
                        } while (command != '\"');
                    }
                    case '@' -> pointer = null;
                }
            }
            if (pointer != null) {
                pointer.moveTo(direction);
            }
        }
    }
}
