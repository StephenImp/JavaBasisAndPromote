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

        //通知最后发送时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date());
        String format2 = format.format(new Date());

        System.out.println(format1);
        System.out.println(format2);

        if (format1.equals(format2)){
            System.out.println("111");
        }

        Date dd = format.parse(format1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        String T3 = format.format(calendar.getTime() ) ;

        System.out.println(T3);

    }



}
