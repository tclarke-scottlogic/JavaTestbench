import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;

class Disc implements Comparable<Disc>
{
    Disc(int centre, int radius){
        this.centre = centre;
        this.radius = radius;
    }

    public int getMin(){
        return centre - radius;
    }
    public int getMax(){
        return centre + radius;
    }

    public String toString(){
        return "{" + getMin() + "," + centre + "," + getMax() +  "}";
    }

    public int compareTo(Disc disc){
        return this.getMax() - disc.getMax();
    }

    public int centre;
    private int radius;
}

public class DiscIntersections {
    private int solve_slow(int[] input) {
        List<Disc> circles = new ArrayList<>(input.length);
        for(int i = 0; i < input.length; ++i){
            circles.add(new Disc(i, input[i]));
        }
//        System.out.println(circles);

        int count = 0;
        for(int i = 0; i < circles.size(); ++i){
            Disc disc = circles.get(i);
            for(int j = i+1; j < circles.size(); ++j){
                Disc further_disc = circles.get(j);
                if(disc.getMax() >= further_disc.getMin()){
                    if(count == 10000000){
                        return -1;
                    }
//                    System.out.println(disc + " " + further_disc);
                    ++count;
                }
            }
        }
        return count;
    }

    class MinComparator implements Comparator<Disc>{

        @Override
        public int compare(Disc o1, Disc o2) {
            return o2.getMin() - o1.getMin();
        }
    }

    class MaxComparator implements Comparator<Disc>{
        @Override
        public int compare(Disc o1, Disc o2) {
            return o2.getMax() - o1.getMax();
        }
    }

    private int solve_quick(int[] input){
        int count = 0;

        List<Disc> circles = new ArrayList<>(input.length);
        for(int i = 0; i < input.length; ++i){
            circles.add(new Disc(i, input[i]));
        }

        List<Disc> max_circles = new ArrayList<>(circles);

        circles.sort(new MinComparator());
        max_circles.sort(new MaxComparator());


        System.out.println(circles);
        System.out.println(max_circles);
        System.out.println("--------");

        return count;
    }

    public int solve(int[] input){
        return solve_quick(input);
    }

    @Test
    public void Test(){
        int[] A  = { 0, 0, 0 };
        Assert.assertEquals(0, this.solve(A));
    }

    @Test
    public void TestA1(){
        int[] A  = { 0, 1 };
        Assert.assertEquals(1, this.solve(A));
    }

    @Test
    public void TestA(){
        int[] A  = { 0, 0, 1 };
        Assert.assertEquals(1, this.solve(A));
    }

    @Test @Ignore
    public void TestB(){
        int[] A  = { 1, 1, 1 };
        Assert.assertEquals(3, this.solve(A));
    }

    @Test @Ignore
    public void TestC(){
        int[] A  = { 1, 1, 1, 1, 1 };
        Assert.assertEquals(7, this.solve(A));
    }

    @Test @Ignore
    public void TestD(){
        int[] A  = { 1, 1, 1, 1, 2 };
        Assert.assertEquals(8, this.solve(A));
    }

    @Test @Ignore
    public void TestX(){
        int[] A  = { 1, 5, 2, 1, 4, 0 };
        Assert.assertEquals(11, this.solve(A));
    }

    @Test @Ignore
    public void TestBig(){
        int length = 100;
        int[] A  = new int[length];
        for(int i = 0; i < length; ++i){
            A[i] = 1;
        }
        Assert.assertEquals(197, this.solve(A));
    }

    @Test @Ignore
    public void TestBIG(){
        int length = 100000;
        int[] A  = new int[length];
        for(int i = 0; i < length; ++i){
            A[i] = 1;
        }
        Assert.assertEquals(199997, this.solve(A));
    }
}