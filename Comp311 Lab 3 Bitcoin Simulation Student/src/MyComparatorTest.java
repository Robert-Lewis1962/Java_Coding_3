import junit.framework.TestCase;
/**
 * MyComparatorTest class
 * @author Robert Lewis
 * @version 1.0
 * 
 */
public class MyComparatorTest extends TestCase {
 
    /**
     * test 1
     */
    public void testMyComparator1() {
        MyComparator myComp = new MyComparator();
        Transaction tx1 = new Transaction("cb1");
        tx1.addOutput(new TxOutput("add1", 100));
        Transaction tx2 = new Transaction("cb1");
        tx2.addOutput(new TxOutput("addr1", 100));

        assertEquals(0, myComp.compare(tx1, tx2));
        
    }
    
    /**
     * test 2
     */
    public void testMyComparator2() {
        MyComparator myComp = new MyComparator();
        Transaction tx1 = new Transaction("cb1");
        tx1.addOutput(new TxOutput("add1", 90));
        Transaction tx2 = new Transaction("cb1");
        tx2.addOutput(new TxOutput("addr1", 100));

        assertEquals(-1, myComp.compare(tx1, tx2));
        

    }
    
    /**
     * test 3
     */
    public void testMyComparator3() {
        MyComparator myComp = new MyComparator();
        Transaction tx1 = new Transaction("cb1");
        tx1.addOutput(new TxOutput("add1", 101));
        Transaction tx2 = new Transaction("cb1");
        tx2.addOutput(new TxOutput("addr1", 100));

        assertEquals(1, myComp.compare(tx1, tx2));
        

    }
}
