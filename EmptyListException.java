/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This class is the EmptyListException to be thrown if user tries to do invalid operation while list is empty
 */
public class EmptyListException extends Exception {
    /**
     * Creates EmptyListException object to be thrown
     * @param x Message telling the user the list is empty
     */
    public EmptyListException(String x){
        super(x);
    }
}
