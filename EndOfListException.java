/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * <p>
 * This class is the EndOfListException to be thrown if user tries go access beyond the ends of the list
 */

public class EndOfListException extends Exception {
    /**
     * Creates EndOfListExceptionObject to be thrown
     * @param message Message to be shown is exception is thrown
     */
    public EndOfListException(String message){
        super(message);
    }
}
