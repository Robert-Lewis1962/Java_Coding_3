import java.util.ArrayList;
import java.util.List;
/**
 * Transaction class
 * @author Robert Lewis
 * @version 1.0
 *
 */
public class Transaction {
    private String transId;
    private ArrayList<TxInput> inputList;
    private ArrayList<TxOutput> outputList;
    /**
     * takes in an id for the transaction
     * @param id of the transaction
     */
    public Transaction(String id) {
        this.transId = id;
        this.inputList = new ArrayList<TxInput>();
        this.outputList = new ArrayList<TxOutput>();
    }
    /**
     * adds input to transaction
     * @param input TxInput
     */
    public void addInput(TxInput input) {
        this.inputList.add(input);
    }
    /**
     * adds output to transaction
     * @param output TxOutput
     */
    public void addOutput(TxOutput output) {
        this.outputList.add(output);
    }
    /**
     * gets the transaction fee (output - input = amount)
     * @return the amount 
     */
    public int getTransactionFee() {
        int inFee = 0;
        int outFee = 0;
        for (int i = 0; i < this.getOutputs().size(); i++) {
            int value = this.outputList.get(i).getAmount();
            outFee += value;
        }
        outFee = outFee - 25;
        
        for (int i = 0; i < this.getInputs().size(); i++) {
            int value = this.inputList.get(i).getAmount();
            inFee += value;
        }
        
        
        return outFee - inFee;
    }
    /**
     * returns the id of the transaction
     * @return id 
     */
    public String getId() {
        return this.transId;
    }
    /**
     * returns the list of inputs
     * @return list of inputs
     */
    public List<TxInput> getInputs() {
        return this.inputList;
    }
    /**
     * returns the list of outputs
     * @return list of outputs
     */
    public List<TxOutput> getOutputs() {
        return this.outputList;
    }
}
