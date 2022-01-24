import junit.framework.TestCase;

/**
 * TxIOTest class
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class TxIOTest extends TestCase {
    /**
     * test both input and output
     */
    public void testIO1() {
        TxIO tx = new TxOutput("1", 10);
        assertEquals("1", tx.getAddress());
        assertEquals(10, tx.getAmount());

        tx = new TxInput("2", 20);
        assertEquals("2", tx.getAddress());
        assertEquals(20, tx.getAmount());
    }
    
    /**
     * test both input and output
     */
    public void testIO2() {
        TxOutput tx1 = new TxOutput("1", 10);
        assertEquals("1", tx1.getAddress());
        assertEquals(10, tx1.getAmount());

        TxInput tx2 = new TxInput("2", 20);
        assertEquals("2", tx2.getAddress());
        assertEquals(20, tx2.getAmount());
        
        tx2.setSpentOutput(tx1);
        assertEquals(tx1, tx2.getSpentOutput());
    }
}
