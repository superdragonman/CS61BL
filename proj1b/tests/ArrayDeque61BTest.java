import deque.ArrayDeque61B;

import jh61b.utils.Reflection;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }
    @Test
    public void addFirstTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        deque1.addFirst(20);
        deque1.addFirst(30);
        deque1.addFirst(40);
        assertThat(deque1.toList()).containsExactly(40, 30, 20).inOrder();
        
        ArrayDeque61B<String> deque2 = new ArrayDeque61B<>();
        deque2.addFirst("hello");
        deque2.addFirst("world");
        assertThat(deque2.toList()).containsExactly("world", "hello").inOrder();

        ArrayDeque61B<Integer> deque3 = new ArrayDeque61B<>();
        for (int i = 0; i < 9; i++) {
            deque3.addFirst(i);
        }
        deque3.addFirst(22);
        assertThat(deque3.toList()).containsExactly(22, 8, 7, 6, 5, 4, 3, 2, 1, 0);
    }

    @Test
    public void addLastTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        deque1.addLast(5);
        deque1.addLast(10);
        assertThat(deque1.toList()).containsExactly(5, 10).inOrder();

        ArrayDeque61B<String> deque2 = new ArrayDeque61B<>();
        deque2.addLast("foo");
        deque2.addLast("bar");
        assertThat(deque2.toList()).containsExactly("foo", "bar").inOrder();

        ArrayDeque61B<Integer> deque3 = new ArrayDeque61B<>();
        for (int i = 0; i < 9; i++) {
            deque3.addLast(i);
        }
        deque3.addLast(22);
        assertThat(deque3.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 22);
    }
    
    @Test
    public void getTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.get(4)).isEqualTo(null);
        deque1.addLast(5);
        deque1.addLast(10);
        assertThat(deque1.get(5)).isEqualTo(null);
        assertThat(deque1.get(-2)).isEqualTo(null);
        assertThat(deque1.get(0)).isEqualTo(5);
        assertThat(deque1.get(1)).isEqualTo(10);
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.isEmpty()).isTrue();
        deque1.addFirst(55);
        assertThat(deque1.isEmpty()).isFalse();
    }

    @Test
    public void sizeTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.size()).isEqualTo(0);
        deque1.addFirst(33);
        assertThat(deque1.size()).isEqualTo(1);
    }

    @Test
    public void  toListTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.toList()).containsExactly().inOrder();
        deque1.addFirst(22);
        deque1.addFirst(33);
        deque1.addFirst(44);
        assertThat(deque1.toList()).containsExactly(44, 33, 22).inOrder();
    }

    @Test
    public void removeFirstTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.removeFirst()).isEqualTo(null);
        deque1.addFirst(22);
        deque1.addFirst(33);
        deque1.addFirst(44);
        assertThat(deque1.removeFirst()).isEqualTo(44);
        assertThat(deque1.toList()).containsExactly(33, 22).inOrder();

        ArrayDeque61B<Character> deque3 = new ArrayDeque61B<>();
        for (int i = 0; i < 100; i++) {
            deque3.addFirst((String.valueOf(i).charAt(0)));
        }
        for (int i = 0; i < 98; i++) {
            deque3.removeFirst();
        }
        assertThat(deque3.toList()).containsExactly('1', '0');
    }

    @Test
    public void removeLastTest() {
        ArrayDeque61B<Integer> deque1 = new ArrayDeque61B<>();
        assertThat(deque1.removeLast()).isEqualTo(null);
        deque1.addFirst(22);
        deque1.addFirst(33);
        deque1.addFirst(44);
        assertThat(deque1.removeLast()).isEqualTo(22);
        assertThat(deque1.toList()).containsExactly(44, 33).inOrder();

        ArrayDeque61B<Character> deque3 = new ArrayDeque61B<>();
        for (int i = 0; i < 100; i++) {
            deque3.addLast((String.valueOf(i).charAt(0)));
        }
        for (int i = 0; i < 98; i++) {
            deque3.removeLast();
        }
        assertThat(deque3.toList()).containsExactly('0', '1');
    }
}
