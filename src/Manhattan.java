import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Manhattan {
    int run(int[] skyline){
        Stack<Integer> blocks = new Stack<>();
        int count = 0;
        for(int i = 0; i < skyline.length; ++i){
            System.out.println(blocks);
            // If it's lower
            // Remove blocks higher than the thing
            while(!blocks.empty() && skyline[i] < blocks.peek()){
                blocks.pop();
            }

            if(blocks.empty()){
                blocks.push(skyline[i]);
                ++count;
                continue;
            }
            // If it's the same height
            if(skyline[i] == blocks.peek()){
                // No block needed
                continue;
            }

            // If it's higher
            // add a new block on top
            if(skyline[i] > blocks.peek()){
                blocks.push(skyline[i]);
                ++count;
                continue;
            }
        }
        return count;
    }

    @Test
    public void Test1() {
        int[] a = new int[]{};

        Assert.assertEquals(0, this.run(a));
    }

    @Test
    public void Test2() {
        int[] a = new int[]{1};

        Assert.assertEquals(1, this.run(a));
    }

    @Test
    public void Test3() {
        int[] a = new int[]{1,1,1,1,1};

        Assert.assertEquals(1, this.run(a));
    }

    @Test
    public void Test4() {
        int[] a = new int[]{1,2,2,1,1};

        Assert.assertEquals(2, this.run(a));
    }


    @Test
    public void Test5() {
        int[] a = new int[]{8,8,5,7,9,8,7,4,8};

        Assert.assertEquals(7, this.run(a));
    }
}
