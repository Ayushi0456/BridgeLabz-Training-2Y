import java.text.SimpleDateFormat;
import java.util.Date;

interface DateUtils {
    static String format(Date d) {
        return new SimpleDateFormat("dd-MM-yyyy").format(d);
    }
}

public class DateFormat {
    public static void main(String[] args) {
        System.out.println(DateUtils.format(new Date()));
    }
}

