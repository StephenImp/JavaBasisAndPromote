package breakDemo;

public class TestBreakDemo {

    public static void main(String[] args) {

        int num = 0;

        for (int i = 0; i <10 ; i++) {

            if (num>9){
                break;
            }

            for (int j = 0; j <5 ; j++) {

                num = num +1;
                if (num>9){
                    break;
                }

            }

            System.out.println("i ="+i);

        }


    }
}
