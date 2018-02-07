import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;


public class Fishing {
    public class Fish{
        public Fish(int size, int direction){
            this.size = size;
            this.direction = direction;
        }
        int size;
        int direction;

        public Fish fight(Fish last_fish){
            size -= last_fish.size;
            if(size < 0){
                size = size * -1;
                direction = (direction == 0) ? 1 : 0;
            }
            return this;
        }

        public String toString(){
            return ((direction == 1) ? ">" : "{") + "="+ size + "=" + ((direction == 1) ? "}" : "<");
        }
    }

    public int run(int[] A, int[] B) {
        if(A.length != B.length)
            throw new IllegalArgumentException("Unacceptable arguments");

        Stack<Fish> fishes = new Stack<>();

        for(int i = 0; i < A.length; ++i){
            Fish fish = new Fish(A[i], B[i]);

            if(fish.direction == 1){
                fishes.push(fish);
            }
            else{
                while(fishes.size() > 0 && fishes.peek().direction == 1){
                    Fish last_fish = fishes.pop();
                    System.out.println(last_fish + " vs " + fish);
                    if(fish.size < last_fish.size){
                        fish = last_fish;
                        break;
                    }
                }
                fishes.push(fish);
            }
            System.out.println(fishes);
        }

        System.out.println(fishes);
        return fishes.size();
    }


    @Test
    public void Test1() {
        int[] a = new int[]{};
        int[] b = new int[]{};

        Assert.assertEquals(0,this.run(a,b));
    }

    @Test
    public void Test2() {
        int[] a = new int[]{3};
        int[] b = new int[]{1};

        Assert.assertEquals(1,this.run(a,b));
    }

    @Test
    public void Test3() {
        int[] a = new int[]{3,4,5,6,7};
        int[] b = new int[]{1,1,1,1,1};

        Assert.assertEquals(5,this.run(a,b));
    }

    @Test
    public void Test3a() {
        int[] a = new int[]{3,4,5,6,7};
        int[] b = new int[]{0,0,0,0,0};

        Assert.assertEquals(5,this.run(a,b));
    }

    @Test
    public void Test4() {
        int[] a = new int[]{3,3,1,1,7};
        int[] b = new int[]{1,1,1,1,0};

        Assert.assertEquals(1,this.run(a,b));
    }


    @Test
    public void Test5() {
        int[] a = new int[]{3,2,1,4};
        int[] b = new int[]{1,1,0,0};

        Assert.assertEquals(1,this.run(a,b));
    }

    @Test
    public void Test5a() {
        int[] a = new int[]{3,1,1,3};
        int[] b = new int[]{0,0,1,1};

        Assert.assertEquals(4,this.run(a,b));
    }

    @Test
    public void Test6() {
        int[] a = new int[]{4, 3, 2, 1, 5};
        int[] b = new int[]{0, 1, 0, 0, 0};

        Assert.assertEquals(2, this.run(a,b));
    }
}

