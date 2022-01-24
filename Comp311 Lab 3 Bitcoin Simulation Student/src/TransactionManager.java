import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TransactionManger class
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class TransactionManager {
    /** Max transactions per block */
    public static final int MAX_TX_PER_BLOCK = 3;
    /** Reward for producing block */
    public static final int BLOCK_REWARD = 25;

    private PQ<Transaction> transHeap;
    private ArrayList<Transaction> transList;
    private ArrayList<TxOutput> utxoList;

    /**
     * default constructor
     */
    public TransactionManager() {
        MyComparator comp = new MyComparator();
        this.transHeap = new PQ<>(comp);
        this.transList = new ArrayList<>();
        this.utxoList = new ArrayList<>();
    }

    /**
     * checks the given block for validity
     * 
     * @param newBlock the given block
     * @return true if block is valid
     */
    public boolean isBlockValid(Block newBlock) {
        Block b = newBlock;
        List<TxOutput> outList = new ArrayList<>();
        List<TxInput> inList = new ArrayList<>();
        int outTotal = 0;
        List<Transaction> nbTransactions = b.getTransactions();

        List<TxOutput> coinList = nbTransactions.get(0).getOutputs();

        // check 1
        for (int i = 0; i < coinList.size(); i++) {
            outTotal += coinList.get(i).getAmount();
        }

        if (outTotal != 
                nbTransactions.get(0).getTransactionFee() + BLOCK_REWARD) {

            return false;
        }

        // check 2
        for (int i = 0; i < nbTransactions.size(); i++) {
            outList.addAll(nbTransactions.get(i).getOutputs());
        }

        int j = 0;
        while (j < outList.size()) {
            String address = outList.get(j).getAddress();
            int amount = outList.get(j).getAmount();

            int utxoAmount = this.getUTXO(address);
            if (amount != utxoAmount) {

                return false;
            }

            j++;
        }

        // check 3
        for (int i = 0; i < nbTransactions.size(); i++) {
            inList.addAll(nbTransactions.get(i).getInputs());
        }

        j = 0;
        while (j < inList.size()) {
            String address = inList.get(j).getAddress();
            int amount = inList.get(j).getAmount();
            int utxoAmount = this.getUTXO(address);

            if (amount != utxoAmount) {

                return false;
            }

            j++;
        }

        // check 4
        for (int i = 1; i < nbTransactions.size(); i++) {
            inList = nbTransactions.get(i).getInputs();
            outList = nbTransactions.get(i).getOutputs();
            int inSum = 0;
            int outSum = 0;
            for (j = 0; j < inList.size(); j++) {
                inSum += inList.get(j).getAmount();
            }
            for (j = 0; j < outList.size(); j++) {
                outSum += outList.get(j).getAmount();
            }

            if (inSum < outSum) {

                return false;
            }
        }

        return true;
    }

    /**
     * executes the block??
     * 
     * @param block being passed in
     */
    public void executeBlock(Block block) {
        Block b = block;
        List<Transaction> templist = b.getTransactions();
        Transaction tx = templist.get(0);
        this.addPendingTransaction(tx);

//        if (!tx.getInputs().isEmpty()) {
//
//            List<TxInput> input = tx.getInputs();
//            String address = input.get(0).getAddress();
//            int amount = input.get(0).getAmount();
//            int value = this.getUTXO(address);
//            int total = amount - value;
//            TxOutput oldOutput = new TxOutput(address, value);
//            TxOutput tempOutput = new TxOutput(address, total);
            // step 1 add transaction to pending list

//            this.utxoList.add(tempOutput);
            // step two get input's address and check againsgt UTXO list

            // step 3 get the remaining total

            // step 4 delete the address in the UTXO list thats already there

            // step 5 create new amount add it to the UTXO list

            // *****
            // update pending and Queuedlist

//        }
    }

    /**
     * undo the transactions in given block
     * 
     * @param block the given block
     */
    public void undoBlock(Block block) {
       // Block b = block;
    }

    /**
     * adds transaction fees to the pq
     * 
     * @param tx transaction
     */
    public void addPendingTransaction(Transaction tx) {
        this.transHeap.offer(tx);
        for (int i = 0; i < tx.getOutputs().size(); i++) {
            TxOutput op = tx.getOutputs().get(i);
            this.utxoList.add(op);
        }

    }

    /**
     * get the top 3 transactions in the pq
     * 
     * @return list of up to top 3 transactions
     */
    public List<Transaction> getTransactionsForNextBlock() {

        int i = 0;
        int size = this.transHeap.size();
        if (size > MAX_TX_PER_BLOCK) {
            size = 3;
        }
        while (i < size) {
            this.transList.add(this.transHeap.poll());
            i++;
        }

        return this.transList;
    }

    /**
     * gets the transactions that are in the pq
     * 
     * @return list of transaction left in the pq
     */
    public List<Transaction> getQueuedTransactions() {
        Iterator<Transaction> pointer = this.transHeap.iterator();
        ArrayList<Transaction> list = new ArrayList<>();

        while (pointer.hasNext()) {
            list.add(pointer.next());
        }
        return list;
    }

    /**
     * amount of bitcoins belong to a certain address
     * 
     * @param addr the bitcoins belong to
     * @return the address
     */
    public int getUTXO(String addr) {
        for (int i = 0; i < this.utxoList.size(); i++) {
            String opAddress = this.utxoList.get(i).getAddress();
            if (opAddress.equals(addr)) {
                return this.utxoList.get(i).getAmount();
            }
        }

        return 0;
    }
}
