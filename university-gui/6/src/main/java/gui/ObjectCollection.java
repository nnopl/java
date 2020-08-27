package gui;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
public class ObjectCollection<TItem> implements Iterable<TItem> {

    private Object[] collection;

    class MyIterator implements ListIterator<TItem> {
        private int cursorPosition = -1;

        @Override
        @SuppressWarnings("unchecked")
        public TItem next() {
            if(!hasNext())
                throw new NoSuchElementException();

            cursorPosition = nextIndex();
            return (TItem) collection[cursorPosition];
        }

        @Override
        public boolean hasNext() {
            return cursorPosition + 1 < collection.length;
        }

        @Override
        public boolean hasPrevious() {
            return cursorPosition >= 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public TItem previous() {
            if(!hasPrevious())
                throw new NoSuchElementException();

            cursorPosition = previousIndex();
            return (TItem) collection[cursorPosition--];
        }

        @Override
        public int nextIndex() {
            return cursorPosition + 1;
        }

        @Override
        public int previousIndex() {
            return cursorPosition;
        }

        @Override
        public void set(TItem o) {
            if(cursorPosition < 0 || cursorPosition >= collection.length)
                throw new IllegalStateException();

            collection[cursorPosition] = o;
        }

        @Override
        public void remove() {
            if(cursorPosition < 0 || cursorPosition >= collection.length)
                throw new IllegalStateException();

            Object[] newArray = new Object[collection.length-1];
            int index = 0;
            for(int i = 0; i < collection.length; i++)
            {
                if(cursorPosition != i)
                    newArray[index++] = collection[i];
            }
            collection = newArray;
        }

        @Override
        public void add(TItem o) {
            Object[] newCollection = new Object[collection.length+1];
            int insertAt = nextIndex();

            for (int i = 0; i < collection.length; i++) {
                if(i >= insertAt)
                    newCollection[i + 1] = collection[i];
                else
                    newCollection[i] = collection[i];
            }
            newCollection[insertAt] = o;
            collection = newCollection;
            cursorPosition = insertAt;
        }
    }

    public ObjectCollection(int initialSize) {
        this.collection = new Object[initialSize];
    }

    public ListIterator<TItem> listIterator() {
        return new MyIterator();
    }

    @SuppressWarnings("unchecked")
    public TItem get(int index) {
        return (TItem) collection[index];
    }

    @Override
    public Iterator<TItem> iterator() {
        return new MyIterator();
    }
}
