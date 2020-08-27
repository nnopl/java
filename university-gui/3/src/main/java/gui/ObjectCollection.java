package gui;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectCollection implements Iterable<Object> {

    private Object[] collection;

    class MyIterator implements Iterator<Object> {
        private int currentIndex = 0;
        private boolean removed = false;

        @Override
        public boolean hasNext() {
            return currentIndex+1 < collection.length;
        }

        @Override
        public Object next() throws NoSuchElementException {
            if(!hasNext()) throw new NoSuchElementException();

            removed = false;
            return collection[++currentIndex];
        }

        @Override
        public void remove() {
            if (removed) return;

            delete(currentIndex);
            currentIndex--;
        }
    }

    public ObjectCollection(int initialSize) {
        this.collection = new Object[initialSize];
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyIterator();
    }

    public void delete(int removeIndex) {
        Object[] newArray = new Object[collection.length-1];
        int index = 0;
        for(int i = 0; i < collection.length; i++)
        {
            if(removeIndex != i)
                newArray[index++] = collection[i];
        }
        collection = newArray;
    }

    public void insert(int index, Object value) {
        collection[index] = value;
    }
}
