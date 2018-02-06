// you can also use imports, for example:
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Counter{
    public Counter(){
        this.array = new int[5];
    }

    public Counter(Counter prev){
        this.array = Arrays.copyOf(prev.array, prev.array.length);
    }

    private int getVal(char letter){
        switch(letter){
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
        }
        return 0;
    }

    public void increment(char letter){
        ++array[getVal(letter)];
    }

    public int getMinImpact(Counter p){
        for(int i = 1; i <= 4; ++i){
            if(array[i] - p.array[i] > 0){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        return Arrays.toString(array);
    }

    private int[] array;
};

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        Counter[] counters = new Counter[S.length()];

        counters[0] = new Counter();

        for (int i = 0; i < S.length(); ++i) {
            if (i > 0)
                counters[i] = new Counter(counters[i - 1]);
            
            counters[i].increment(S.charAt(i));
        }

        int[] output = new int[P.length];
        for (int i = 0; i < P.length; ++i) {
            Counter counter = (P[i] != 0) ? counters[P[i] - 1] : new Counter();
            output[i] = counters[Q[i]].getMinImpact(counter);
        }

        return output;
    }

    @Test
    public void BasicTest() {
        String str = "ACGTGAC";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};

        int[] value = solution(str, p, q);
        int[] expected = {3, 1, 1};
        Assert.assertArrayEquals(value, expected);
    }

    @Test
    public void OtherTest() {
        String str = "CAGCCTA";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};

        int[] value = solution(str, p, q);
        int[] expected = {2, 4, 1};
        Assert.assertArrayEquals(value, expected);
    }
    @Test
    public void AllAs() {
        String str = "AAAAAAA";
        int[] p = {1, 5, 0};
        int[] q = {3, 5, 6};

        int[] value = solution(str, p, q);
        int[] expected = {1,1, 1};
        Assert.assertArrayEquals(value, expected);
    }

    @Test
    public void AllGs() {
        String str = "GGGGGGG";
        int[] p = {2, 5, 0};
        int[] q = {4, 5, 6};

        int[] value = solution(str, p, q);
        int[] expected = {3,3,3};
        Assert.assertArrayEquals(value, expected);
    }
};
