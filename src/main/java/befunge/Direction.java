package befunge;

public class Direction {
    private int x;
    private int y;
    private char command;
    public Direction(char command){
        setCommand(command);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCommand() {
        return command;
    }

    public void setCommand(char command) {
        this.command = command;
        switch (command) {
            case '<' -> {
                this.x = 0;
                this.y = -1;
            }
            case '^' -> {
                this.x = -1;
                this.y = 0;
            }
            case 'v' -> {
                this.x = 1;
                this.y = 0;
            }
            case '?' ->{
                this.x=(int)(Math.random()*10)%2;
                this.y=this.x==0?1:0;
                if(Math.random()*10>4.9){
                    this.x*=-1;
                    this.y*=-1;
                }
            }
            default -> {
                this.x = 0;
                this.y = 1;
            }
        }
    }
}
