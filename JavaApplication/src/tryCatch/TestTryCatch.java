package tryCatch;

public class TestTryCatch {

    public static void main(String[] args) {

        try {
            try {
                int i = 5 / 0;
                System.out.println("⑥");
            } catch (Exception e) {

            }
            System.out.println("①");

        } catch (Exception e) {
            System.out.println("②");
        }

        System.out.println("④");

    }
}
