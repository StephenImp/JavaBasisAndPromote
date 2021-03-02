/**
 * @author Steph
 */
public class TestCase {

    public static void main(String[] args) {

        Integer total = 6;
        Integer size = 3;

        Integer count = 0;

        if (total % size == 0) {
            count = total / size;
        } else {
            count = total / size + 1;
        }

        System.out.println(count);

    }

}
