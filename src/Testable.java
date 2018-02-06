import org.junit.Assert;
import org.junit.Test;

public class Testable {
    private boolean run(){
        return true;
    }

    @Test
    public void BasicTest() {
        boolean value = run();
        Assert.assertTrue(value);
    }

    public static void main(String[] inputs){
        System.out.println("Work you bucket of bolts");
        Testable testable = new Testable();
        if(testable.run()){
            System.out.println("I did");
        }

    }
}
