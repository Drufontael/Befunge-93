package befunge;

public class Screen {
    private char[][] screen=new char[25][80];
    private String commandString;


    public Screen() {
    }

    public Screen(String commandString) {
        this.commandString = commandString;
    }

    public char[][] getScreen() {
        return screen;
    }

    public String getCommandString() {
        return commandString;
    }
    protected void reader(){
        String[] lines=commandString.split("\n");
        for(int i=0;i<lines.length;i++){
            char[] instructions=lines[i].toCharArray();
            for(int j=0;j<instructions.length;j++){
                screen[i][j]=instructions[j];
            }
        }
    }
    public char command(Pointer pointer){
        return screen[pointer.getX()][pointer.getY()];
    }
    public void modify(int x,int y,int v){
        screen[x][y]=(char) v;
    }
}
