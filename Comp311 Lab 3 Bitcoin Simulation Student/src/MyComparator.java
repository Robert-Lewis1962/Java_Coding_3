import java.util.Comparator;

/**
 * MyComparator class
 * 
 * @author Robert Lewis
 * @version 1.0
 * 
 */

public class MyComparator implements Comparator<Transaction> {
    /**
     * @param o1 first object
     * @param o2 second object
     * @return -1, 0, or 1 as the first argument is <, ==, or >
     *         than the second
     */
    @Override
    public int compare(Transaction o1, Transaction o2) {
        int fee1 = o1.getTransactionFee();
        int fee2 = o2.getTransactionFee();
        
        if (fee1 == fee2) {
            return 0;
        } 
        else if (fee1 > fee2) {
            return 1;
        } 
    
        return -1;
    }
}
