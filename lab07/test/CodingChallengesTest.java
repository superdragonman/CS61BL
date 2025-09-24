import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class CodingChallengesTest {

    @Test
    public void testMissingNumber() {
	// TODO
        int [] values1 = {3, 0, 1};
        assertWithMessage("Test Case 1").that(CodingChallenges.missingNumber(values1)).isEqualTo(2);
        int [] values2 = {0, 1};
        assertWithMessage("Test Case 2").that(CodingChallenges.missingNumber(values2)).isEqualTo(2);
        int [] values3 = {9,6,4,2,3,5,7,0,1};
        assertWithMessage("Test Case 3").that(CodingChallenges.missingNumber(values3)).isEqualTo(8);
    }

    @Test
    public void testIsPermutation() {
	// TODO
        String s1 = "anagram", s2 = "nagaram";
        assertWithMessage("Test Case 1").that(CodingChallenges.isPermutation(s1, s2)).isTrue();
        String s3 = "rat", s4 = "car";
        assertWithMessage("Test Case 2").that(CodingChallenges.isPermutation(s3, s4)).isFalse();
        String s5 = "a", s6 = "ab";
        assertWithMessage("Test Case 3").that(CodingChallenges.isPermutation(s5, s6)).isFalse();
    }
}
