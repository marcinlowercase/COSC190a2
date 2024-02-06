package cosc190_assignment_2;

public class RecursiveMethods {

    public static String reverse(String sText) {
        if (sText.length() <= 1) return sText;
        String reversed = reverse(sText.substring(1)) + sText.charAt(0);
        return reversed;
    }

    public static int bin2Dec(String binNumber) {
        return 0;
    }

    public static void replaceAll(String oldWord, String newWord, String filePath) {
    }
}
