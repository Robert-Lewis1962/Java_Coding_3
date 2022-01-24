import java.util.List;


import junit.framework.TestCase;
/**
 * TransactionManager Test class
 * @author Robert Lewis
 * @version 1.0
 */
public class TransactionManagerTest extends TestCase {

    /**
     * test addPending and QueuedTransactions
     */
    public void testTransactionManger1() {
        TransactionManager tm = new TransactionManager();
        
        assertEquals(0, tm.getQueuedTransactions().size());
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        assertEquals(1, tm.getQueuedTransactions().size());
        assertEquals("cb1", tm.getQueuedTransactions().get(0).getId());
        
        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr1", 150));
        
        tm.addPendingTransaction(tx);
        assertEquals(2, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());
    }
    
    /**
     * test addPending / TransactionForNextBlock / QueuedTransactions
     */
    public void testTransactionManger2() {
        TransactionManager tm = new TransactionManager();
        
        assertEquals(0, tm.getTransactionsForNextBlock().size());
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));        
        tm.addPendingTransaction(tx);

        
        assertEquals(1, tm.getQueuedTransactions().size());
        assertEquals("cb1", tm.getQueuedTransactions().get(0).getId());

        assertEquals(1, tm.getTransactionsForNextBlock().size());
        assertEquals("cb1", tm.getTransactionsForNextBlock().get(0).getId());
        assertEquals(0, tm.getQueuedTransactions().size());
    }
    
    /**
     * test addPending / TransactionForNextBlock / QueuedTransactions
     */
    public void testTransactionManger3() {
        TransactionManager tm = new TransactionManager();
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr1", 150));       
        tm.addPendingTransaction(tx);
        
        assertEquals(2, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());

        assertEquals(2, tm.getTransactionsForNextBlock().size());
        assertEquals("cb2", tm.getTransactionsForNextBlock().get(0).getId());
        assertEquals("cb1", tm.getTransactionsForNextBlock().get(1).getId());
        
        assertEquals(0, tm.getQueuedTransactions().size());
        
    }
    
    /**
     * test addPending / TransactionForNextBlock / QueuedTransactions
     */
    public void testTransactionManger4() {
        TransactionManager tm = new TransactionManager();
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr1", 150));       
        tm.addPendingTransaction(tx);
        
        tx = new Transaction("cb3");
        tx.addOutput(new TxOutput("addr1", 60));        
        tm.addPendingTransaction(tx);
        
        assertEquals(3, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());
        assertEquals("cb3", tm.getQueuedTransactions().get(2).getId());

        assertEquals(3, tm.getTransactionsForNextBlock().size());
        assertEquals("cb2", tm.getTransactionsForNextBlock().get(0).getId());
        assertEquals("cb1", tm.getTransactionsForNextBlock().get(1).getId());
        assertEquals("cb3", tm.getTransactionsForNextBlock().get(2).getId());
        
        assertEquals(0, tm.getQueuedTransactions().size());
        
    }
    
    /**
     * test addPending / TransactionForNextBlock / QueuedTransactions
     */
    public void testTransactionManger5() {
        TransactionManager tm = new TransactionManager();
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr1", 150));       
        tm.addPendingTransaction(tx);
        
        tx = new Transaction("cb3");
        tx.addOutput(new TxOutput("addr1", 60));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb4");
        tx.addOutput(new TxOutput("addr1", 1));       
        tm.addPendingTransaction(tx);
        
        assertEquals(4, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());
        assertEquals("cb3", tm.getQueuedTransactions().get(2).getId());
        assertEquals("cb4", tm.getQueuedTransactions().get(3).getId());
        
        List<Transaction>  list = tm.getTransactionsForNextBlock();
        assertEquals("cb2", list.get(0).getId());
        assertEquals("cb1", list.get(1).getId());
        assertEquals("cb3", list.get(2).getId());
        
        assertEquals(1, tm.getQueuedTransactions().size());
        assertEquals("cb4", tm.getQueuedTransactions().get(0).getId());
    }
    
    /**
     * test addPending / TransactionForNextBlock / QueuedTransactions
     */
    public void testTransactionManger6() {
        TransactionManager tm = new TransactionManager();
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr1", 150));       
        tm.addPendingTransaction(tx);
        
        tx = new Transaction("cb3");
        tx.addOutput(new TxOutput("addr1", 60));        
        tm.addPendingTransaction(tx);

        tx = new Transaction("cb4");
        tx.addOutput(new TxOutput("addr1", 1));       
        tm.addPendingTransaction(tx);
        
        tx = new Transaction("cb5");
        tx.addOutput(new TxOutput("addr1", 60));       
        tm.addPendingTransaction(tx);
        
        assertEquals(5, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());
        assertEquals("cb3", tm.getQueuedTransactions().get(2).getId());
        assertEquals("cb4", tm.getQueuedTransactions().get(3).getId());
        assertEquals("cb5", tm.getQueuedTransactions().get(4).getId());
        
        List<Transaction>  list = tm.getTransactionsForNextBlock();
        assertEquals("cb2", list.get(0).getId());
        assertEquals("cb1", list.get(1).getId());
        assertEquals("cb4", list.get(2).getId());
        
        assertEquals(2, tm.getQueuedTransactions().size());
        assertEquals("cb3", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb5", tm.getQueuedTransactions().get(1).getId());
    }
    
    /**
     * test addPending and QueuedTransactions / UTXO
     */
    public void testTransactionManger7() {
        TransactionManager tm = new TransactionManager();
        
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        assertEquals(1, tm.getQueuedTransactions().size());
        assertEquals("cb1", tm.getQueuedTransactions().get(0).getId());
        assertEquals(100, tm.getUTXO("addr1"));
        
        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr2", 150));
        
        tm.addPendingTransaction(tx);
        assertEquals(2, tm.getQueuedTransactions().size());
        assertEquals("cb2", tm.getQueuedTransactions().get(0).getId());
        assertEquals("cb1", tm.getQueuedTransactions().get(1).getId());
        assertEquals(100, tm.getUTXO("addr1"));
        assertEquals(150, tm.getUTXO("addr2"));
        assertEquals(0, tm.getUTXO("addr5"));
    }
    
    /**
     * is block valid test 1 check 1
     */
    public void testIsBlockV1() {
        TransactionManager tm = new TransactionManager();

        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        b.addTransaction(tx);
        assertEquals(75, tx.getTransactionFee());
        
        assertFalse(tm.isBlockValid(b));
    }
    
    /**
     * is block valid test 2 check 1
     */
    public void testIsBlockV2() {
        TransactionManager tm = new TransactionManager();

        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        b.addTransaction(tx);
        tx.addInput(new TxInput("addr3", 100));
        b.addTransaction(tx);
        assertEquals(-25, tx.getTransactionFee());
        
        assertFalse(tm.isBlockValid(b));
    }
    
    /**
     * is block valid test 3 check 2 fail
     */
    public void testIsBlockV3() {
        TransactionManager tm = new TransactionManager();

        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        
        tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 101));
        Block b = new Block("hash1");
        
        b.addTransaction(tx);
        assertEquals(76, tx.getTransactionFee());
        
        assertEquals(100, tm.getUTXO("addr1"));
        assertFalse(tm.isBlockValid(b));
    }
    
    /**
     * is block valid test 4 check 3 fail
     */
    public void testIsBlockV4() {
        TransactionManager tm = new TransactionManager();
        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(75, tx.getTransactionFee());
        tx = new Transaction("cb2");
        tx.addInput(new TxInput("addr1", 101));
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(-126, tx.getTransactionFee());
        
        assertEquals(100, tm.getUTXO("addr1"));
        assertFalse(tm.isBlockValid(b)); 
    }
    
    /**
     * is block valid test check 1,2,3 pass for now 
     */
    public void testIsBlockV5() {
        TransactionManager tm = new TransactionManager();
        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(75, tx.getTransactionFee());
        tx = new Transaction("cb2");
        tx.addInput(new TxInput("addr1", 100));
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(-125, tx.getTransactionFee());
        
        assertEquals(100, tm.getUTXO("addr1"));
        assertTrue(tm.isBlockValid(b)); 
    }
    
    /**
     * is block valid test check 4 fail
     */
    public void testIsBlockV6() {
        TransactionManager tm = new TransactionManager();
        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(75, tx.getTransactionFee());
        tx = new Transaction("cb2");
        tx.addInput(new TxInput("addr1", 100));
        tx.addOutput(new TxOutput("addr3", 101));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(-24, tx.getTransactionFee());
        
        assertEquals(100, tm.getUTXO("addr1"));
        assertFalse(tm.isBlockValid(b)); 
    }
    
    /**
     * is block valid test check all 4 pass
     */
    public void testIsBlockV7() {
        TransactionManager tm = new TransactionManager();
        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(75, tx.getTransactionFee());
        tx = new Transaction("cb2");
        tx.addInput(new TxInput("addr1", 100));
        tx.addOutput(new TxOutput("addr3", 100));
        
        tm.addPendingTransaction(tx);
        b.addTransaction(tx);
        assertEquals(-25, tx.getTransactionFee());
        
        assertEquals(100, tm.getUTXO("addr1"));
        assertTrue(tm.isBlockValid(b)); 
    }
    
    
    /**
     * execute block 1
     */
    public void testExecute1() {
        TransactionManager tm = new TransactionManager();

        Block b = new Block("hash1");
        Transaction tx = new Transaction("cb1");
        tx.addOutput(new TxOutput("addr1", 100));
        b.addTransaction(tx);
        tm.executeBlock(b);
        assertEquals(100, tm.getUTXO("addr1"));

        b = new Block("hash2");
        tx = new Transaction("cb2");
        tx.addOutput(new TxOutput("addr2", 50));
        b.addTransaction(tx);
        tx = new Transaction("transfer");
        tx.addInput(new TxInput("addr1", 100));
        tx.addOutput(new TxOutput("addr3", 75));
        tx.addOutput(new TxOutput("addr4", 25));
        b.addTransaction(tx);
        tm.executeBlock(b);
        assertEquals(50, tm.getUTXO("addr2"));
//        assertEquals(0, tm.getUTXO("addr1"));
//        assertEquals(75, tm.getUTXO("addr3"));
//        assertEquals(25, tm.getUTXO("addr4"));

    }
    
    
    
    
}
