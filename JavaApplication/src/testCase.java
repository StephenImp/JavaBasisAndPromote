import java.math.BigDecimal;
import java.text.ParseException;

public class testCase {

    public static void main(String[] args) throws ParseException {

        BigDecimal bigDecimal = new BigDecimal(5);
        BigDecimal bigDecimal2 = new BigDecimal(8);

        int i = bigDecimal.compareTo(bigDecimal2);

        System.out.println(i);

    }
}
