package tech.angular.emplyeemanager.exception;

import java.io.Serial;

/**
 * @autor Juan David Morantes Vergara
 */
public class DataNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -5052930694766358091L;
    public DataNotFoundException(String aMensa){
        super(aMensa);
    }
}
