/**
 * TxIO class
 * @author Robert Lewis
 * @version 1.0
 */

public abstract class TxIO {
    private String ipAddress;
    private int bitAmount;
    /**
     * takes in an address and amount
     * @param address of the input/output
     * @param amount of the input/output
     */
    public TxIO(String address, int amount) {
        this.ipAddress = address;
        this.bitAmount = amount;
    }
    /**
     * getAddress returns address
     * @return address
     */
    public String getAddress() {
        return this.ipAddress;
    }
    /**
     * getAmount returns the amount
     * @return amount
     */
    public int getAmount() {
        return this.bitAmount;
    }
}
