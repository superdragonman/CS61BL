package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public class Node {
        private T value;
        private Node prev;
        private Node next;

        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }


    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node current = sentinel.next;
        while (current != sentinel) {
            list.add(current.value);
            current = current.next;
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
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
        T firstValue = sentinel.next.value;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return firstValue;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T lastValue = sentinel.prev.value;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return lastValue;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return sentinel.next.value;
        } else {
            LinkedListDeque61B<T> subDeque = new LinkedListDeque61B<>();
            subDeque.sentinel = this.sentinel.next;
            subDeque.size = this.size - 1;
            return subDeque.getRecursive(index - 1);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDeque61Biterator();
    }

    private class LinkedListDeque61Biterator implements Iterator<T> {
        private Node wizPos;

        public LinkedListDeque61Biterator() {
            wizPos = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return wizPos != sentinel;
        }

        @Override
        public T next() {
            T returnItem = wizPos.value;
            wizPos = wizPos.next;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 同一性检查
        if (this == obj) {
            return true;
        }

        // 2. 类型检查：检查 obj 是否是 Deque61B 接口的一个实现
        if (!(obj instanceof Deque61B<?>)) {
            return false;
        }

        // 3. 类型转换
        Deque61B<?> other = (Deque61B<?>) obj;

        // 4. 大小检查
        if (this.size() != other.size()) {
            return false;
        }

        // 5. 内容检查：逐个比较元素
        for (int i = 0; i < this.size(); i++) {
            // 使用 get(i) 方法获取元素并用 .equals() 比较
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }

        // 6. 所有检查都通过，则认为相等
        return true;
    }

    @Override
    public String toString() {
        return toList().toString();
    }


}
