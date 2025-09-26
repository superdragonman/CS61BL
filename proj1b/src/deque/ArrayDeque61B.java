package deque;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class ArrayDeque61B<T> implements Deque61B<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resizingUp();
        }
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resizingUp();
        }
        items[nextLast] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            returnList.add(items[current]);
            current = (current + 1) % items.length;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size < items.length * 0.25) {
            resizingDown();
        }
        T value = items[(nextFirst + 1) % items.length];
        nextFirst = (nextFirst + 1) % items.length;
        items[nextFirst] = null;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (size < items.length * 0.25) {
            resizingDown();
        }
        T value = items[(nextLast - 1 + items.length) % items.length];
        nextLast = (nextLast - 1 + items.length) % items.length;
        items[nextLast] = null;
        size--;
        return value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public void resizingUp() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length * 2];
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void resizingDown() {
        @SuppressWarnings("unchecked")
        T[] newItems = (T[]) new Object[items.length / 2];
        int current = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[current];
            current = (current + 1) % items.length;
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDeque61Biterator();
    }

    private class ArrayDeque61Biterator implements Iterator<T> {
        private int wizPos;
        private int count;

        public ArrayDeque61Biterator() {
            wizPos = (nextFirst + 1) % items.length;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T returnItem = items[wizPos];
            wizPos = (wizPos + 1) % items.length;
            count++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Deque61B<?>)) {
            return false;
        }
        Deque61B<?> other = (Deque61B<?>) obj;

        if (this.size() != other.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}
