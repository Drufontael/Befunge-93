package befunge;

import java.util.Stack;

public class Interpreter {
    private final Screen screen;
    private final StringBuilder print = new StringBuilder();
    private Pointer pointer = new Pointer(0, 0);
    private Direction direction = new Direction('>');
    private final Stack<Integer> stack = new Stack<>();

    public Interpreter(Screen screen) {
        this.screen = screen;
        setPrint();
    }

    public String getPrint() {
        return print.toString();
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setPrint() {
        int a, b, x, y, v;
        while (pointer != null) {
            char command = screen.command(pointer);
            if (command>='0' && command <= '9') stack.push((int) command - 48);
            else {
                switch (command) {
                    case '<' -> direction = new Direction('<');
                    case '>' -> direction = new Direction('>');
                    case '^' -> direction = new Direction('^');
                    case 'v' -> direction = new Direction('v');
                    case '?' -> direction = new Direction('?');
                    case '#' -> pointer.moveTo(direction);
                    case '_' -> {
                        if (stack.pop() == 0) direction = new Direction('>');
                        else direction = new Direction('<');
                    }
                    case '|' -> {
                        if (stack.pop() == 0) direction = new Direction('v');
                        else direction = new Direction('^');
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
                    case '$' -> stack.pop();
                    case '.' -> {
                        Integer integer = stack.pop();
                        print.append(integer);
                    }
                    case ',' -> {
                        char character = (char) stack.pop().intValue();
                        print.append(character);
                    }
                    case 'p' -> {
                        x = stack.pop();
                        y = stack.pop();
                        v = stack.pop();
                        screen.modify(x, y, v);
                    }
                    case 'g' -> {
                        x = stack.pop();
                        y = stack.pop();
                        char vC = screen.command(new Pointer(x, y));
                        stack.push((int) vC);
                    }
                    case '\"' -> {
                        do {
                            pointer.moveTo(direction);
                            command = screen.command(pointer);
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
