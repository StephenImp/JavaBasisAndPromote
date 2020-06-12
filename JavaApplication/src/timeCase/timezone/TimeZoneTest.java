package timeCase.timezone;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {

	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdfMs = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		Date depDate = sdfMs.parse("2018/06/12 016:0:00");
		Date arrDate = sdfMs.parse("2018/06/12 16:00:00");
		
		//String s = getDatesOffsetWithTimeZone(depDate,"-14400",arrDate,"28800");
		String s = getDatesOffsetWithTimeZone(depDate,"28800",arrDate,"-14400");

		System.out.println(s);
		
	}
	
	
	 public static String getDatesOffsetWithTimeZone(Date date1,String zone1,Date date2,String zone2){
	    	
	      int parseOffset1 = Integer.parseInt(zone1);
		  //1.获取时区
		  String[] availableIDs = TimeZone.getAvailableIDs(parseOffset1*1000);
		  String availableId = availableIDs[0];
		  //获取这个时区的timeZone
		  TimeZone paseTimeZone1 = TimeZone.getTimeZone(availableId);
		  System.out.println("paseTimeZone1:------------->"+paseTimeZone1);
		  
		  int parseOffset2 = Integer.parseInt(zone2);
		  String[] availableIDs2 = TimeZone.getAvailableIDs(parseOffset2*1000);
		  String availableId2 = availableIDs2[0];
		  
		  //获取这个时区的timeZone
		  TimeZone paseTimeZone2 = TimeZone.getTimeZone(availableId2);
		  System.out.println("paseTimeZone2:------------->"+paseTimeZone2);
		  
//	      //全部转化成GMT格式
//	      String gmt1 = "";
//	      String gmt2 = "";
//	      if(paseTimeZone1!=null && !paseTimeZone1.equals("") && paseTimeZone2!=null && !paseTimeZone2.equals("")){
//	          //拼接成GMT格式
//	          gmt1 = "GMT"+paseTimeZone1+":00";
//	          gmt2 = "GMT"+paseTimeZone2+":00";
//	      }
//		 System.out.println("gmt1@@@@@@@@@"+gmt1);
//		 System.out.println("gmt2@@@@@@@@@"+gmt2);
//
//	      TimeZone timeZone1 = TimeZone.getTimeZone(gmt1);
//	      TimeZone timeZone2 = TimeZone.getTimeZone(gmt2);
//
//		 System.out.println("timeZone1########"+timeZone1);
//		 System.out.println("timeZone2########"+timeZone2);
		 /**
		  * 计算相差的毫秒数
		  *getOffset(long date) 方法用于获取在指定的日期与UTC的时区偏移
		  */
	      long timeZoneOffset = paseTimeZone2.getOffset(date2.getTime()) - paseTimeZone1.getOffset(date1.getTime());
	      long millisOffset = date2.getTime() - date1.getTime();
	      long ms = millisOffset - timeZoneOffset;

	      //计算相差的时间
	      Integer ss = 1000;  
	      Integer mi = ss * 60;  
	      Integer hh = mi * 60;  
	      Integer dd = hh * 24;  

	      Long day = ms / dd;  
	      Long hour = (ms - day * dd) / hh;  
	      Long minute = (ms - day * dd - hour * hh) / mi;  
	      Long second = (ms - day * dd - hour * hh - minute * mi) / ss;  
	      Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;  

	      StringBuffer sb = new StringBuffer();  
	      if(day > 0) {  
	          sb.append(day+"天");  
	      }  
	      if(hour > 0) {  
	          sb.append(hour+"小时");  
	      }  
	      if(minute > 0) {  
	          sb.append(minute+"分");  
	      }  
	      if(second > 0) {  
	          sb.append(second+"秒");  
	      }  
	      if(milliSecond > 0) {  
	          sb.append(milliSecond+"毫秒");  
	      }  
	      return sb.toString();  
	    	
	    }
}
