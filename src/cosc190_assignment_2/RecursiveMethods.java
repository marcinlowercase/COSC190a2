package cosc190_assignment_2;

public class RecursiveMethods {

    public static String reverse(String sText) {
        if (sText.length() <= 1) return sText;
        StringBuilder reversed = new StringBuilder();
        reversed.append(reverse(sText.substring(1)));
        reversed.append(sText.charAt(0));
        return reversed.toString();
    }

    public static int bin2Dec(String binNumber) {
        return 0;
    }

    public static void replaceAll(String oldWord, String newWord, String filePath) {
    }
}
