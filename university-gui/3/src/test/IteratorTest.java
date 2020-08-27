import gui.ObjectCollection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class IteratorTest {

    @Test
    public void ObjectCollectionTestWithIterator(){

        ObjectCollection collection = new ObjectCollection(20);

        // Fill in with 0-19 values
        for(int i = 0; i < 20; i++)
            collection.insert(i, i);

        // Go through collection and remove even numbers
        Iterator ite = collection.iterator();
        while(ite.hasNext())
        {
            Object obj = ite.next();
            if(((Integer)obj) %2 == 0)
                ite.remove();
        }

        // Use for each loop (using iterator)
        // to check whether array contains only even elements
        for(Object obj : collection) {
            Assert.assertNotEquals(0, ((Integer) obj) % 2);
        }
    }
}
