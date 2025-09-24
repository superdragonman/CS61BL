import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        // TODO
        Set<Integer> missNumber = new HashSet<>();
        for (int num : values) {
            missNumber.add(num);
        }
        for (int i = 0; i <= values.length; i++) {
            if (!missNumber.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        // TODO
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            Integer count = counts.get(c);
            if (count == null || count == 0) {
                return false;
            }
            counts.put(c, count - 1);
        }
        return true;
    }
}
