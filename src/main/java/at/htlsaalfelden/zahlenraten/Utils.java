package at.htlsaalfelden.zahlenraten;

public class Utils {
    private Utils() {}

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isPrintable(String s) {
        return s.replaceAll("\\p{C}", "").length() == 1;
    }
}
