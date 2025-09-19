import java.util.ArrayList;
import java.util.List;

public class ArrayExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        // TODO: Fill in this function.
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        // TODO: Fill in this function.
        int min = array[0], max = array[0];
        for (int num : array){
            if (num < min){
                min = num;
            }
            if (num > max){
                max = num;
            }
        }
        return max - min;
    }

}
