// BOJ 10699
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main14 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(df.format(date));
    }
}