package DataStructures.Quece.queue;

/**
 * Created by admin on 2018/7/3.
 */
public class QueceApp {

    public static void main(String[] args) {
        Queue theQuece = new Queue(5);

        theQuece.insert(10);
        theQuece.insert(20);
        theQuece.insert(30);
        theQuece.insert(40);

        theQuece.remove();
        theQuece.remove();
        theQuece.remove();

        theQuece.insert(50);
        theQuece.insert(60);
        theQuece.insert(70);
        theQuece.insert(80);
        theQuece.insert(90);

        while (!theQuece.isEmpty()) {
            long n = theQuece.remove();
            System.out.println(n);
            System.out.println("");
        }
        System.out.println("");
    }
}
