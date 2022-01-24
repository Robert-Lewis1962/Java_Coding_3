/**
 * TxInput class
 * @author Robert Lewis
 * @version 1.0
 */
public class TxInput extends TxIO {
    private TxOutput txOut;
    /**
     * takes in an address and amount
     * @param address of input
     * @param amount of input
     */
    public TxInput(String address, int amount) {
        super(address, amount);
    }
    /**
     * gets the output this input is spending
     * @return the output
     */
    public TxOutput getSpentOutput() {
        return this.txOut;
    }
    /**
     * set the output the input is spending
     * @param source the output
     */
    public void setSpentOutput(TxOutput source) {
        this.txOut = source;
    }
}
