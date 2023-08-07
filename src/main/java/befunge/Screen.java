package befunge;

import exceptions.BefungeException;

public class Screen {
    protected int rows;
    protected int colunms;
    protected char[][] screen;
    protected String commandString;
    protected Pointer pointer = new Pointer(0, 0);
    protected Direction direction = new Direction('>');

    //By default, there are 25 lines and 80 columns within the Befunge-93 programming
    public Screen() {
        rows=25;
        colunms=80;
        screen=new char[rows][colunms];
    }

    public Screen(String commandString) {
        rows=25;
        colunms=80;
        screen=new char[rows][colunms];
        this.commandString = commandString;
        setScreen();
    }

    //Constructor where we can set the screen size.
    public Screen(int rows, int colunms, String commandString) {
        this.rows = rows;
        this.colunms = colunms;
        this.screen=new char[rows][colunms];
        this.commandString = commandString;
    }

    public char[][] getScreen() {
        return screen;
    }

    public String getCommandString() {
        return commandString;
    }
    protected void setScreen(){
        String[] lines=commandString.split("\n");
        if(lines.length>rows) throw new BefungeException("Number of rows exceeds screen limit");
        for(int i=0;i<lines.length;i++){
            char[] instructions=lines[i].toCharArray();
            if(instructions.length>colunms) throw new BefungeException("Command line size exceeds screen limit");
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
