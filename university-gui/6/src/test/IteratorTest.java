import gui.ObjectCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ListIterator;

public class IteratorTest {

    @Test
    public void ObjectCollectionTestAdd() {
        ObjectCollection<Integer> collection = new ObjectCollection<>(0);

        // Fill in with 0-19 values
        ListIterator<Integer> iterator = collection.listIterator();
        for(Integer i = 0; i < 20; i++) {
            iterator.add(i);
        }

        // Check if added correctly
        for(Integer i = 0; i < 20; i++) {
            Assert.assertEquals(i, collection.get(i));
        }
    }

    @Test
    public void ObjectCollectionTestNext() {
        ObjectCollection<Integer> collection = new ObjectCollection<>(0);

        // Fill in with 0-19 values
        ListIterator<Integer> iterator = collection.listIterator();
        for(int i = 0; i < 20; i++) {
            iterator.add(i);
        }

        // Check next
        iterator = collection.listIterator();
        for(int i = 0; i < 20; i++)
        {
            int value = iterator.next();
            Assert.assertEquals(i, value);
        }
    }

    @Test
    public void ObjectCollectionTestPrevious() {
        ObjectCollection<Integer> collection = new ObjectCollection<>(0);

        // Fill in with 0-19 values
        ListIterator<Integer> iterator = collection.listIterator();
        for(int i = 0; i < 20; i++) {
            iterator.add(i);
        }

        // iterate from end
        for(int i = 19; i >= 0; i--)
        {
            int value = iterator.previous();
            Assert.assertEquals(i, value);
        }
    }

    @Test
    public void ObjectCollectionTestRemove(){

        ObjectCollection<Integer> collection = new ObjectCollection<>(0);

        // Fill in with 0-19 values
        ListIterator<Integer> iterator = collection.listIterator();
        for(int i = 0; i < 20; i++) {
            iterator.add(i);
        }

        // Go through collection and remove even numbers
        iterator = collection.listIterator();
        while(iterator.hasNext())
        {
            Integer value = iterator.next();
            if(value % 2 == 0)
                iterator.remove();
        }

        // Use for each loop (using iterator)
        // to check whether array contains only even elements
        for(Integer value : collection) {
            Assert.assertNotEquals(0,  value % 2);
        }
    }
}
