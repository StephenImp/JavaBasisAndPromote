import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class testCase {

    public static void main(String[] args) throws ParseException {

        BigDecimal bigDecimal = new BigDecimal(5);
        BigDecimal bigDecimal2 = new BigDecimal(8);

        int i = bigDecimal.compareTo(bigDecimal2);

        System.out.println(i);

    }
}
