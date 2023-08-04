package exceptions;

import java.io.Serial;

public class BefungeException extends RuntimeException{
    @Serial
    private static final long serialVersionUID=1;
    public BefungeException(String msg){
        super(msg);
    }
}
