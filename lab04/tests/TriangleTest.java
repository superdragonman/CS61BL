import org.junit.Rule;
import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;
public abstract class TriangleTest {

    /** For autograding purposes; do not change this line. */
    abstract Triangle getNewTriangle();

    /* ***** TESTS ***** */

    // FIXME: Add additional tests for Triangle.java here that pass on a
    //  correct Triangle implementation and fail on buggy Triangle implementations.

    @Test
    public void test1() {
        // TODO: stub for first test
        Triangle t = getNewTriangle();
        // remember that you'll have to call on Triangle methods like
        // t.functionName(arguments), where t is a Triangle object
        assertWithMessage("They construct a triangle.").that(t.sidesFormTriangle(2,2,3)).isTrue();
        assertWithMessage("They cannot construct a triangle.").that(t.sidesFormTriangle(1,2,3)).isFalse();
        assertWithMessage("They cannot construct a triangle.").that(t.sidesFormTriangle(3,0,4)).isFalse();
        assertWithMessage("They cannot construct a triangle.").that(t.sidesFormTriangle(0,0,0)).isFalse();
    }

    @Test
    public void test2() {
        // TODO: stub for second test
        Triangle t = getNewTriangle();
        assertWithMessage("They construct a triangle.").that(t.pointsFormTriangle(0,0,3,0,0,4)).isTrue();
        assertWithMessage("They cannot construct a triangle.").that(t.pointsFormTriangle(0,0,1,1,2,2)).isFalse();
        assertWithMessage("They cannot construct a triangle.").that(t.pointsFormTriangle(0,0,0,0,0,0)).isFalse();
    }

    @Test
    public void test3() {
        // TODO: stub for third test
        Triangle t = getNewTriangle();
        assertWithMessage("They form an Scalene triangle.").that(t.triangleType(2,3,4)).isEqualTo("Scalene");
        assertWithMessage("They form an Isosceles triangle.").that(t.triangleType(2,2,3)).isEqualTo("Isosceles");
        assertWithMessage("They form an Equilateral triangle.").that(t.triangleType(2,2,2)).isEqualTo("Equilateral");
    }

    @Test
    public void test4() {
        // TODO: stub for fourth test
        Triangle t = getNewTriangle();
        assertWithMessage("The squared hypotenuse is 25.").that(t.squaredHypotenuse(3,4)).isEqualTo(25);
        assertWithMessage("The squared hypotenuse is 13.").that(t.squaredHypotenuse(2,3)).isEqualTo(13);
        assertWithMessage("The squared hypotenuse is 0.").that(t.squaredHypotenuse(0,0)).isEqualTo(0);
    }

}
