package timeCase.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by admin on 2018/6/12.
 */
public class TestDate {

    public static void main(String[] argc) {

        int parseOffset1 = Integer.parseInt("-14400");

        String[] availableIDs = TimeZone.getAvailableIDs(parseOffset1*1000);

        String availableId = availableIDs[0];
        TimeZone paseTimeZone1 = TimeZone.getTimeZone(availableId);

        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date pase = null;
        try {
            pase = dff.parse("2018-06-12 16:10:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dff.setTimeZone(paseTimeZone1);
        String ee = dff.format(pase);

        System.out.println(ee);
    }
}
