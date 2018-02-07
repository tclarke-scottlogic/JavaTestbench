// you can also use imports, for example:
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Triangle {
    public int solve(int[] A) {
        Arrays.sort(A);
        for(int i = 0; i < A.length-2; ++i){
            int p = A[i];
            int q = A[i+1];
            int r = A[i+2];

//            System.out.println("r-q: " + (r-q));

            if( r-q < p){
//                System.out.println("Match!");
                return 1;
            }
        }
//        System.out.println("No Match!");
        return 0;
    }

    @Test
    public void BasicTest() {
        int[] arr = new int[]{10,15,20};
        int value = this.solve(arr);
        Assert.assertEquals(1, value);
    }

    @Test
    public void AnotherTest() {
        int[] arr = new int[]{10,15,40};
        int value = this.solve(arr);
        Assert.assertEquals(0, value);
    }

    @Test
    public void Close() {
        int[] arr = new int[]{5,10,15};
        int value = this.solve(arr);
        Assert.assertEquals(0, value);
    }

    @Test
    public void OneVal() {
        int[] arr = new int[]{1,1,1};
        int value = this.solve(arr);
        Assert.assertEquals(1, value);
    }

    @Test
    public void TwoVal() {
        int[] arr = new int[]{2,2,2};
        int value = this.solve(arr);
        Assert.assertEquals(1, value);
    }

    @Test
    public void MaxValTest() {
        int[] arr = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        int value = this.solve(arr);
        Assert.assertEquals(1, value);
    }

}