import java.util.Iterator;

import junit.framework.TestCase;

/**
 * PQTest class
 * 
 * @author Robert Lewis
 * @version 1.0
 *
 */
public class PQTest extends TestCase {
    /**
     * test 1 empty PQ and offer null
     */
    public void testPQ1() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        assertNotNull(pq);
        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());
        assertEquals(null, pq.peek());
    }
    
    /**
     * test 1 offer to PQ
     */
    public void testOffer1() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        assertNotNull(pq);
        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());
        assertEquals(null, pq.peek());
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        assertTrue(pq.offer(tx));
        
        assertFalse(pq.isEmpty());
        assertEquals(1, pq.size());
        assertEquals(75, pq.peek().getTransactionFee());

        Iterator<Transaction> z = pq.iterator();

        assertTrue(z.hasNext());
        assertEquals("cb1", z.next().getId());
        assertFalse(z.hasNext());
    }

    /**
     * test 2 offer to PQ
     */
    public void testOffer2() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        assertNotNull(pq);
        assertTrue(pq.isEmpty());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());
        assertEquals(null, pq.peek());

        Transaction tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("10");
        tx.addOutput(new TxOutput("addr1", 10));
        assertTrue(pq.offer(tx));
        tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("24");
        tx.addOutput(new TxOutput("addr1", 24));
        assertTrue(pq.offer(tx));
        assertFalse(pq.isEmpty());
        assertEquals(5, pq.size());
        assertEquals(-1, pq.peek().getTransactionFee());

        Iterator<Transaction> z = pq.iterator();

        assertTrue(z.hasNext());
        assertEquals("24", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("10", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertFalse(z.hasNext());

    }

    /**
     * test 3 offer to PQ
     */
    public void testOffer3() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);

        Transaction tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("10");
        tx.addOutput(new TxOutput("addr1", 10));
        assertTrue(pq.offer(tx));
        tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("24");
        tx.addOutput(new TxOutput("addr1", 24));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("0");
        tx.addOutput(new TxOutput("addr1", 0));
        assertTrue(pq.offer(tx));
        tx = new Transaction("25");
        tx.addOutput(new TxOutput("addr1", 25));
        assertTrue(pq.offer(tx));
        tx = new Transaction("26");
        tx.addOutput(new TxOutput("addr1", 26));
        assertTrue(pq.offer(tx));
        tx = new Transaction("27");
        tx.addOutput(new TxOutput("addr1", 27));
        assertTrue(pq.offer(tx));
        tx = new Transaction("28");
        tx.addOutput(new TxOutput("addr1", 28));
        assertTrue(pq.offer(tx));
        tx = new Transaction("0");
        tx.addOutput(new TxOutput("addr1", 0));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("19");
        tx.addOutput(new TxOutput("addr1", 19));
        assertTrue(pq.offer(tx));
        tx = new Transaction("30");
        tx.addOutput(new TxOutput("addr1", 30));
        assertTrue(pq.offer(tx));
        assertFalse(pq.isEmpty());
        assertEquals(15, pq.size());
        assertEquals(5, pq.peek().getTransactionFee());

        Iterator<Transaction> z = pq.iterator();

        assertTrue(z.hasNext());
        assertEquals("30", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("27", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("28", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("24", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("26", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("19", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("10", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("25", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertFalse(z.hasNext());
        
        

    }

    /**
     * test poll to empty PQ
     */
    public void testPoll1() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        

        assertEquals(0, pq.size());
        assertEquals(null, pq.peek());
        assertEquals(null, pq.poll());

    }
    
    /**
     * test poll to 1 in PQ
     */
    public void testPoll2() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));


        assertEquals(1, pq.size());
        assertEquals(-22, pq.peek().getTransactionFee());
        
        z = pq.iterator();

        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        assertEquals("3", pq.poll().getId());
        assertEquals(0, pq.size());
        assertEquals(null, pq.peek());

    }
    
    /**
     * test poll to 2 in PQ
     */
    public void testPoll3() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));

        assertEquals(2, pq.size());
        assertEquals(-21, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        assertEquals("4", pq.poll().getId());
        assertEquals(1, pq.size());
        assertEquals("3", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
    }
    
    /**
     * test poll to 3 in PQ
     */
    public void testPoll4() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));

        assertEquals(3, pq.size());
        assertEquals(-22, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        
        assertEquals("3", pq.poll().getId());
        assertEquals(2, pq.size());
        assertEquals("2", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
    }
    
    /**
     * test poll to 3 in PQ
     */
    public void testPoll5() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));

        assertEquals(3, pq.size());
        assertEquals(-22, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        
        assertEquals("3", pq.poll().getId());
        assertEquals(2, pq.size());
        assertEquals("2", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
    }
    
    /**
     * test poll to 4 in PQ
     */
    public void testPoll6() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));

        assertEquals(4, pq.size());
        assertEquals(-21, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        
        assertEquals("4", pq.poll().getId());
        assertEquals(3, pq.size());
        assertEquals("3", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
    }
    
    /**
     * test poll to 4 in PQ
     */
    public void testPoll7() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));

        assertEquals(4, pq.size());
        assertEquals(-21, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        
        assertEquals("4", pq.poll().getId());
        assertEquals(3, pq.size());
        assertEquals("3", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
    }
    
    /**
     * test poll to 5 in PQ
     */
    public void testPoll8() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("5");
        tx.addOutput(new TxOutput("addr1", 5));
        assertTrue(pq.offer(tx));

        assertEquals(5, pq.size());
        assertEquals(-20, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        
        assertEquals("5", pq.poll().getId());
        assertEquals(4, pq.size());
        assertEquals("4", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
    }
    
    /**
     * test poll to 5 in PQ
     */
    public void testPoll9() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("5");
        tx.addOutput(new TxOutput("addr1", 5));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));

        assertEquals(5, pq.size());
        assertEquals(-20, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        
        assertEquals("5", pq.poll().getId());
        assertEquals(4, pq.size());
        assertEquals("4", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
    }
    
    /**
     * test poll to 6 in PQ
     */
    public void testPoll10() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 3));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("5");
        tx.addOutput(new TxOutput("addr1", 5));
        assertTrue(pq.offer(tx));
        tx = new Transaction("10");
        tx.addOutput(new TxOutput("addr1", 10));
        assertTrue(pq.offer(tx));

        assertEquals(6, pq.size());
        assertEquals(-15, pq.peek().getTransactionFee());
       
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("10", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        assertEquals("10", pq.poll().getId());
        assertEquals(5, pq.size());
        assertEquals("5", pq.peek().getId());
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
    }
    
//    /**
//     * test poll to 6 in PQ
//     */
//    public void testPoll11() {
//        MyComparator comp = new MyComparator();
//        PQ<Transaction> pq = new PQ<>(comp);
//        Iterator<Transaction> z = pq.iterator();
//
//        Transaction tx = new Transaction("1");
//        tx.addOutput(new TxOutput("addr1", 10));
//        assertTrue(pq.offer(tx));
//        tx = new Transaction("2");
//        tx.addOutput(new TxOutput("addr1", 9));
//        assertTrue(pq.offer(tx));
//        tx = new Transaction("3");
//        tx.addOutput(new TxOutput("addr1", 9));
//        assertTrue(pq.offer(tx));
//        tx = new Transaction("4");
//        tx.addOutput(new TxOutput("addr1", 8));
//        assertTrue(pq.offer(tx));
//
//        assertEquals(4, pq.size());
//        assertEquals(-15, pq.peek().getTransactionFee());
//       
//        z = pq.iterator();
//        assertTrue(z.hasNext());
//        assertEquals("1", z.next().getId());
//        assertTrue(z.hasNext());
//        assertEquals("2", z.next().getId());
//        assertTrue(z.hasNext());
//        assertEquals("3", z.next().getId());
//        assertTrue(z.hasNext());
//        assertEquals("4", z.next().getId());
//
//        
//        assertEquals("1", pq.poll().getId());
//        assertEquals(3, pq.size());
//        assertEquals("2", pq.peek().getId());
//        
//        z = pq.iterator();
//        assertTrue(z.hasNext());
//        assertEquals("2", z.next().getId());
//        assertTrue(z.hasNext());
//        assertEquals("4", z.next().getId());
//        assertTrue(z.hasNext());
//        assertEquals("3", z.next().getId());
//    }
    
    /**
     * test poll to 7 in PQ
     */
    public void testPoll12() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 100));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 75));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 88));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 201));
        assertTrue(pq.offer(tx));
        tx = new Transaction("5");
        tx.addOutput(new TxOutput("addr1", 105));
        assertTrue(pq.offer(tx));
        tx = new Transaction("6");
        tx.addOutput(new TxOutput("addr1", 79));
        assertTrue(pq.offer(tx));
        tx = new Transaction("7");
        tx.addOutput(new TxOutput("addr1", 80));
        assertTrue(pq.offer(tx));
        tx = new Transaction("8");
        tx.addOutput(new TxOutput("addr1", 251));
        assertTrue(pq.offer(tx));
        tx = new Transaction("9");
        tx.addOutput(new TxOutput("addr1", 160));
        assertTrue(pq.offer(tx));
        tx = new Transaction("10");
        tx.addOutput(new TxOutput("addr1", 35));
        assertTrue(pq.offer(tx));
        tx = new Transaction("11");
        tx.addOutput(new TxOutput("addr1", 99));
        assertTrue(pq.offer(tx));
        tx = new Transaction("12");
        tx.addOutput(new TxOutput("addr1", 62));
        assertTrue(pq.offer(tx));
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("8", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("9", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("6", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("7", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("10", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("11", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("12", z.next().getId());
        
        assertEquals("8", pq.poll().getId());
        assertEquals(11, pq.size());        
        assertEquals("4", pq.poll().getId());
        assertEquals(10, pq.size());
        assertEquals("9", pq.poll().getId());
        assertEquals(9, pq.size());
        assertEquals("5", pq.poll().getId());
        assertEquals(8, pq.size());
        assertEquals("1", pq.poll().getId());
        assertEquals(7, pq.size());
        assertEquals("11", pq.poll().getId());
        assertEquals(6, pq.size());
        assertEquals("3", pq.poll().getId());
        assertEquals(5, pq.size());
        assertEquals("7", pq.poll().getId());
        assertEquals(4, pq.size());
        assertEquals("6", pq.poll().getId());
        assertEquals(3, pq.size());
        assertEquals("2", pq.poll().getId());
        assertEquals(2, pq.size());
        assertEquals("12", pq.poll().getId());
        assertEquals(1, pq.size());
        assertEquals("10", pq.poll().getId());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());

    } 
    
    /**
     * test poll to 8 in PQ
     */
    public void testPoll13() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 12));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 10));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 9));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 8));
        assertTrue(pq.offer(tx));
        
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());

        
        assertEquals("1", pq.poll().getId());
        assertEquals(3, pq.size());     
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        assertEquals("2", pq.poll().getId());
        assertEquals(2, pq.size());
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        
        assertEquals("3", pq.poll().getId());
        assertEquals(1, pq.size());
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        
        assertEquals("4", pq.poll().getId());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());

    }
    
    /**
     * test poll to 8 in PQ
     */
    public void testPoll14() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 12));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr1", 9));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr1", 10));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr1", 8));
        assertTrue(pq.offer(tx));
        
        
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());

        
        assertEquals("1", pq.poll().getId());
        assertEquals(3, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        
        assertEquals("3", pq.poll().getId());
        assertEquals(2, pq.size());
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        
        assertEquals("2", pq.poll().getId());
        assertEquals(1, pq.size());
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());

        assertEquals("4", pq.remove().getId());
        assertEquals(0, pq.size());
        assertEquals(null, pq.poll());

    }
    
    /**
     * test poll to 8 in PQ
     */
    public void testPoll15() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx = new Transaction("7");
        tx.addOutput(new TxOutput("addr7", 7));
        assertTrue(pq.offer(tx));
        tx = new Transaction("2");
        tx.addOutput(new TxOutput("addr2", 2));
        assertTrue(pq.offer(tx));
        tx = new Transaction("5");
        tx.addOutput(new TxOutput("addr5", 5));
        assertTrue(pq.offer(tx));
        tx = new Transaction("1");
        tx.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx));
        tx = new Transaction("0");
        tx.addOutput(new TxOutput("addr0", 0));
        assertTrue(pq.offer(tx));
        tx = new Transaction("4");
        tx.addOutput(new TxOutput("addr4", 4));
        assertTrue(pq.offer(tx));
        tx = new Transaction("3");
        tx.addOutput(new TxOutput("addr3", 3));
        assertTrue(pq.offer(tx));
        
        assertEquals(7, pq.size());
        // check order
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("7", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        // check order after poll(7)
        assertEquals("7", pq.poll().getId());
        assertEquals(6, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("5", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        
        // check order after poll(5)
        assertEquals("5", pq.poll().getId());
        assertEquals(5, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        
        // check order after poll(4)
        assertEquals("4", pq.poll().getId());
        assertEquals(4, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
     
        // check order after poll(3)
        assertEquals("3", pq.poll().getId());
        assertEquals(3, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        
        // check order after poll(2)
        assertEquals("2", pq.poll().getId());
        assertEquals(2, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        
        // check order after poll(1)
        assertEquals("1", pq.poll().getId());
        assertEquals(1, pq.size());  
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
    }
    
    /**
     * test poll to 9 in PQ
     */
    public void testRemove1() {
        MyComparator comp = new MyComparator();
        PQ<Transaction> pq = new PQ<>(comp);
        Iterator<Transaction> z = pq.iterator();

        Transaction tx1 = new Transaction("7");
        tx1.addOutput(new TxOutput("addr7", 7));
        assertTrue(pq.offer(tx1));
        Transaction tx2 = new Transaction("2");
        tx2.addOutput(new TxOutput("addr2", 2));
        assertTrue(pq.offer(tx2));
        Transaction tx3 = new Transaction("5");
        tx3.addOutput(new TxOutput("addr5", 5));
        assertTrue(pq.offer(tx3));
        Transaction tx4 = new Transaction("1");
        tx4.addOutput(new TxOutput("addr1", 1));
        assertTrue(pq.offer(tx4));
        Transaction tx5 = new Transaction("0");
        tx5.addOutput(new TxOutput("addr0", 0));
        assertTrue(pq.offer(tx5));
        Transaction tx6 = new Transaction("4");
        tx6.addOutput(new TxOutput("addr4", 4));
        assertTrue(pq.offer(tx6));
        Transaction tx7 = new Transaction("3");
        tx7.addOutput(new TxOutput("addr3", 3));
        assertTrue(pq.offer(tx7));
        //not in heap
        Transaction tx0 = new Transaction("6");
        
        assertEquals(7, pq.size());
        assertFalse(pq.remove(tx0));
        assertTrue(pq.remove(tx3));
        
        z = pq.iterator();
        assertEquals(6, pq.size());
        // check order
        z = pq.iterator();
        assertTrue(z.hasNext());
        assertEquals("7", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("2", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("4", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("1", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("0", z.next().getId());
        assertTrue(z.hasNext());
        assertEquals("3", z.next().getId());

    }
}
