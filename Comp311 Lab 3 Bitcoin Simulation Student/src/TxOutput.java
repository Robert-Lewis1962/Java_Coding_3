/**
 * TxOutput class
 * @author Robert Lewis
 * @version 1.0
 */
public class TxOutput extends TxIO {
    /**
     * takes in an address and amount
     * @param address of output
     * @param amount of output
     */
    public TxOutput(String address, int amount) {
        super(address, amount);
    }
}
