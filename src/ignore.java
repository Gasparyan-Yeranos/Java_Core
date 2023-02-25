import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ignore {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Write the date of birthday");
        String dobStr = scanner.nextLine();
//        Date date = sdf.parse(dobStr);
//        System.out.println(date);

        System.out.println(sdf.format(sdf.parse(dobStr)));
    }
}
