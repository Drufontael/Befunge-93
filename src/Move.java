

public class Move {
    private int x;
    private int y;
    private String command;
    public Move(String command){
        setCommand(command);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        switch (command) {
            case ">" -> {
                this.x = 0;
                this.y = 1;
            }
            case "<" -> {
                this.x = 0;
                this.y = -1;
            }
            case "^" -> {
                this.x = -1;
                this.y = 0;
            }
            case "v" -> {
                this.x = 1;
                this.y = 0;
            }
            case "?" ->{
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
