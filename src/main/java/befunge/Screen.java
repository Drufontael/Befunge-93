package befunge;

import exceptions.BefungeException;

public class Screen {
    private final char[][] screen=new char[25][80];
    private String commandString;


    public Screen() {
    }

    public Screen(String commandString) {

        this.commandString = commandString;
        setScreen();

    }

    public char[][] getScreen() {
        return screen;
    }

    public String getCommandString() {
        return commandString;
    }
    protected void setScreen(){
        String[] lines=commandString.split("\n");
        if(lines.length>25) throw new BefungeException("Number of rows exceeds screen limit");
        for(int i=0;i<lines.length;i++){
            char[] instructions=lines[i].toCharArray();
            if(instructions.length>80) throw new BefungeException("Command line size exceeds screen limit");
            System.arraycopy(instructions, 0, screen[i], 0, instructions.length);
        }
    }
    public char command(Pointer pointer){
        return screen[pointer.getX()][pointer.getY()];
    }
    public void modify(int x,int y,int v){
        screen[x][y]=(char) v;
    }
    public void printScreen(){
        for (char[] line:screen){
            for (char command:line){
                if(command!=0) System.out.print(command);
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
