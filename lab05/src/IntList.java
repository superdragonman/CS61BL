/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        // TODO: YOUR CODE HERE
        if (position < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        IntList current = this;
        for (int i = 0; i < position; i++) {
            if (current.next != null) {
                current = current.next;
            } else{
                throw new IllegalArgumentException("YOUR MESSAGE HERE");
            }
        }
        return current.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        // TODO: YOUR CODE HERE
        IntList current = this;
        StringBuilder strNumber = new StringBuilder();
        strNumber.append(this.item);
        while (current.next != null) {
            current = current.next;
            strNumber.append(" ").append(current.item);
            }
        return strNumber.toString();
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parentheses. An example of this is `IntList otherLst = (IntList) obj;`
     * We recommend reviewing the `instanceOf` keyword mentioned in the spec.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof IntList otherList) {
            // TODO: your code here
            IntList currentA = this, currentB = otherList;
            while (currentA != null && currentB != null) {
                if (currentA.item != currentB.item) {
                    return false;
                }
                currentA = currentA.next;
                currentB = currentB.next;
            }
            return currentA == null && currentB == null;
        }
        return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        // TODO: YOUR CODE HERE
        IntList current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new IntList(value);
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        // TODO: YOUR CODE HERE
        IntList current = this;
        int min = this.item;
        while (current != null) {
            if (current.item < min) {
                min = current.item;
            }
            current = current.next;
        }
        return min;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        // TODO: YOUR CODE HERE
        IntList current = this;
        int sum = 0;
        while (current != null) {
            sum += current.item * current.item;
            current = current.next;
        }
        return sum;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively (no modifications to A).
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList catenate(IntList A, IntList B) {
        // TODO: YOUR CODE HERE
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        } else {
            IntList newList = new IntList(A.item, null);
            IntList A_ptr = A.next;
            IntList newList_ptr = newList;
            while (A_ptr != null) {
                newList_ptr.next = new IntList(A_ptr.item, null);
                A_ptr = A_ptr.next;
                newList_ptr = newList_ptr.next;
            }
            newList_ptr.next = B;
            return newList;
        }
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively (make modifications to A).
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        // TODO: YOUR CODE HERE
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }
        IntList current = A;
        while (current.next != null) {
            current = current.next;
        }
        current.next = B;
        return A;
    }
}
