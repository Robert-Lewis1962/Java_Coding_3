import junit.framework.TestCase;

/**
 * Transaction Test class
 * @author Robert Lewis
 * @version 1.0
 */
public class TransactionTest extends TestCase {
    /**
     * test for basic transaction
     */
    public void testTransaction1() {
        Transaction trans1 = new Transaction("qwerty");
        TxInput tx1 = new TxInput("Q", 10);
        TxOutput tx2 = new TxOutput("W", 10);
        trans1.addInput(tx1);
        trans1.addOutput(tx2);
        assertEquals("qwerty", trans1.getId());
        assertEquals(1, trans1.getInputs().size());
        assertEquals(tx1, trans1.getInputs().get(0));
        assertEquals(1, trans1.getOutputs().size());
        assertEquals(tx2, trans1.getOutputs().get(0));
        assertEquals(-25, trans1.getTransactionFee());
    }
}

