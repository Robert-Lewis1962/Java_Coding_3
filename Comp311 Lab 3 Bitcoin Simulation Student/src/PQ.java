import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * PQ class
 * 
 * @author Robert Lewis
 * @version 1.0
 *
 * @param <E> transactions
 */
public class PQ<E> extends AbstractQueue<E> {

    private List<E> elems;
    private Comparator<E> myComp;

    /**
     * takes in a comparator<E>
     * 
     * @param comp <E>
     */
    public PQ(Comparator<E> comp) {
        this.myComp = comp;
        this.elems = new ArrayList<E>();
    }

    @Override
    public boolean offer(E elem) {

        this.elems.add(elem);

        // elem's location
        int value = this.elems.size() - 1;
        // parent's location
        int pValue = (value - 1) / 2;
        // parent of elem
        E parent = this.elems.get(pValue);

        while (this.myComp.compare(elem, parent) == 1) {
            // swaps elem with parent
            Collections.swap(this.elems, pValue, value);

            value = pValue;
            pValue = (value - 1) / 2;
            parent = this.elems.get(pValue);
        }

        return true;
    }

    @Override
    public E peek() {
        if (this.elems.isEmpty()) {
            return null;
        }

        return this.elems.get(0);
    }

    @Override
    public E poll() {
        if (this.elems.isEmpty()) {
            return null;
        }

        Collections.swap(this.elems, 0, this.elems.size() - 1);
        E topNode = this.elems.remove(this.elems.size() - 1);
        this.swap(0);

        return topNode;
    }

    @Override
    public Iterator<E> iterator() {
        return elems.iterator();
    }

    @Override
    public int size() {
        return elems.size();
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.elems.size(); i++) {
            E value = this.elems.get(i);
            if (o.equals(value)) {
                Collections.swap(this.elems, i, this.elems.size() - 1);
                this.elems.remove(this.elems.size() - 1);
                this.swap(i);

                return true;
            }
        }

        return false;
    }

    /**
     * dose the swapping of the heap
     * 
     * @param i is the value being swapped down the heap
     */
    private void swap(int i) {
        while (i < this.elems.size()) {
            E leftChild;
            E rightChild;
            E parent;
            int parentValue = i;
            int leftValue = (2 * i) + 1;
            int rightValue = leftValue + 1;

            // leaf node
            if (leftValue >= this.elems.size()) {
                i = this.elems.size();
            } 
            else {
                // has left leaf node
                if (leftValue < this.elems.size() && 
                        rightValue >= this.elems.size()) {
                    leftChild = this.elems.get(leftValue);

                    if (this.myComp.compare(leftChild,
                            this.elems.get(i)) == 1) {
                        Collections.swap(this.elems, i, leftValue);
                    }
                    i = this.elems.size();
                } 
                else {
                    // has left and right child
                    parent = this.elems.get(parentValue);
                    leftChild = this.elems.get(leftValue);
                    rightChild = this.elems.get(rightValue);

                    if (this.myComp.compare(leftChild, parent) == 1
                            && this.myComp.compare(leftChild,
                                    rightChild) == 1) {

                        Collections.swap(this.elems, i, leftValue);

                        i = leftValue;
                    } 
                    else if (this.myComp.compare(rightChild, parent) == 1
                            && this.myComp.compare(rightChild,
                                    leftChild) == 1) {
                        Collections.swap(this.elems, i, rightValue);

                        i = rightValue;
                    } 
                    else {
                        i = this.elems.size();
                    }

                }
            }
        }
    }

}
