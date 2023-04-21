import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    Flights flights = new Flights();
    Tickets tickets = new Tickets();
    Passengers passengers = new Passengers();
    Admins admins = new Admins();

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">checks that the string is a number</span>
     * @param str the string to be checked for validity
     * @return true if the string is a number, otherwise returns false
     */
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

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">checks that the first letter of the string is uppercase and the other letters are lowercase</span>
     * @param str the string to be checked for validity
     * @return true if the format is valid, otherwise returns false
     */
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

    /**
     *<span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF"> Checks the entered time format</span>
     * @param time the time entered by the users
     * @return true if the entered format for the time is correct , otherwise return false
     */
    public boolean checkTime(String time) {

        Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher matcher = pattern.matcher(time);

        return matcher.find();

    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Checks the entered date format</span>
     * @param date the date entered by the users
     * @return true if the entered format for the date is correct , otherwise return false
     */
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
