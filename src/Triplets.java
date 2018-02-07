// you can also use imports, for example:
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Triplets {
    public int solve(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int lastval1 = A[A.length - 1];
        int lastval2 = A[A.length - 2];
        int lastval3 = A[A.length - 3];

        int firstval1 = A[0];
        int firstval2 = A[1];

        int last_vals =  (lastval1 * lastval2 * lastval3);
        int uses_negatives = (firstval1 * firstval2 * lastval1);

        return last_vals > uses_negatives ? last_vals : uses_negatives;
    }

    @Test
    public void Test1() {
        int[] arr = new int[]{-3, 1, 2, -2, 5, 6};
        int value = this.solve(arr);
        Assert.assertEquals(60, value);
    }

    @Test
    public void Test2() {
        int[] arr = new int[]{-5, -4, -3, -2, -1, 1};
        int value = this.solve(arr);
        Assert.assertEquals(20, value);
    }

    @Test
    public void Test3() {
        int[] arr = new int[]{-5, -4, -3, -2, -1, 1, 2, 3};
        int value = this.solve(arr);
        Assert.assertEquals(60, value);
    }

    @Test
    public void Test4() {
        int[] arr = new int[]{-10, 1, 2, 3, 4, 5};
        int value = this.solve(arr);
        Assert.assertEquals(60, value);
    }

    @Test
    public void Test5() {
        int[] arr = new int[]{-10, -2, 2, 3, 4, 5};
        int value = this.solve(arr);
        Assert.assertEquals(100, value);
    }
}