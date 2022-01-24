import junit.framework.TestCase;
/**
 * BlockTest class
 * @author Robert Lewis
 * @version 1.0
 */
public class BlockTest extends TestCase {
    /**
     * test 1 basic block
     */
    public void testBlock1() {
        Block block1 = new Block("hash1");
        Block block2 = new Block("hash2");
        Transaction trans1 = new Transaction("q");
        TxInput txIn1 = new TxInput("W", 10);
        TxOutput txOut1 = new TxOutput("y", 10);
        
        trans1.addInput(txIn1);
        trans1.addOutput(txOut1);
        
        block1.addChild(block2);
        block2.addTransaction(trans1);
        
        assertEquals(1, block2.getTransactions().size());
        assertEquals(trans1, block2.getTransactions().get(0));
        assertEquals(block1, block2.getParent());
        assertEquals("hash1", block1.getHash());
        assertEquals("hash2", block2.getHash());
    }
}
