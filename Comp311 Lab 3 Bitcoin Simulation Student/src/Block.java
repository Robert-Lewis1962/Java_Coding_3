import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Block class
 * @author Robert Lewis
 *  @version 1.0
 */
public class Block {
    private String blockId;
    private ArrayList<Transaction> transAct;
    private LinkedList<Block> blockChain;
    private Block pBlock;
    /**
     * takes in a hash for the block
     * @param hash id of the block
     */
    public Block(String hash) {
        this.blockId = hash;
        this.transAct = new ArrayList<Transaction>();
        this.blockChain = new LinkedList<Block>();
    }
    /**
     * list of children
     * @param b child
     */
    public void addChild(Block b) {
        b.setParent(this);
        this.blockChain.add(b);
    }
    /**
     * list of transaction in the block
     * @param tx list of transaction
     */
    public void addTransaction(Transaction tx) {
        this.transAct.add(tx);
    }
    /**
     * returns the hash of the block
     * @return hash of block
     */
    public String getHash() {
        return this.blockId;
    }
    /**
     * returns the parent of the block
     * @return the parent of the block
     */
    public Block getParent() {
        return this.pBlock;
    }
    /**
     * returns the list of transactions of the block
     * @return list of transactions
     */
    public List<Transaction> getTransactions() {
        return this.transAct;
    }
    /**
     * sets the parent of the block
     * @param parent of the block
     */
    public void setParent(Block parent) {
        this.pBlock = parent;
    }

}
