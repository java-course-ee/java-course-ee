import java.util.Date;

public class Greeting {
    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Hello " + args[0] + " at " + new Date());
            Thread.sleep(1000);
        }
    }
}