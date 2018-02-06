import java.util.Arrays;

public class MainProg {
    public static void main(String[] args){
        GenomicRangeQuery q = new GenomicRangeQuery();
        int[] array = q.solution("AGGGCCTTAA", new int[]{1,2,3}, new int[]{5,5,5});
        System.out.println(Arrays.toString(array));
    }
}
