import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    Flights flights = new Flights();
    Tickets tickets = new Tickets();
    Passengers passengers = new Passengers();
    Admins admins = new Admins();

    public boolean checkNum(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }
        try {

            Double.parseDouble(str);
            return true;

        } catch (NumberFormatException e) {
            return false;

        }
    }

    public boolean checkLetter(String str) {
        int count = 1;

        char[] character = str.toCharArray();
        if (character[0] >= 'A' && character[0] <= 'Z') {
            for (int i = 1; i < character.length; i++) {
                if (character[i] <= 'z' && character[i] >= 'a') {
                    count++;
                }
            }
            return count == character.length;

        }
        return false;
    }

    public boolean checkTime(String time) {

        Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher matcher = pattern.matcher(time);

        return matcher.find();

    }

    public boolean checkDate(String date) {
        Matcher pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}").matcher(date);

        if (pattern.find()) {
            String[] digits = date.split("/");
            int[] newDigits = new int[digits.length];

            for (int i = 0; i < digits.length; i++)
                newDigits[i] = Integer.parseInt(digits[i]);

            boolean year = newDigits[0] > 0 && newDigits[0] < 9999;
            boolean month = newDigits[1] > 0 && newDigits[1] < 13;
            boolean day;

            if (newDigits[1] > 0 && newDigits[1] < 7) {
                day = newDigits[2] > 0 && newDigits[2] < 32;
            } else if (newDigits[1] == 12) {
                day = newDigits[2] > 0 && newDigits[2] < 30;
            } else
                day = newDigits[2] > 0 && newDigits[2] < 31;

            return month && day && year;

        } else
            return false;
    }
}
