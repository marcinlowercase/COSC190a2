package cosc190_assignment_2;

public class RecursiveMethods {

    public static String reverse(String sText) {
        if (sText.length() <= 1) return sText;
        return reverse(sText.substring(1)) + sText.charAt(0);
    }

    public static int bin2Dec(String binNumber) {
        if (binNumber.length() <= 1) return Integer.parseInt(binNumber);
        return (int) (bin2Dec(binNumber.substring(1)) + Integer.parseInt("" + binNumber.charAt(0)) * Math.pow(2, binNumber.length() - 1));
    }

    public static String justBinary(String binNumber) {
        StringBuilder onlyBin = new StringBuilder();
        for (int i = 0; i < binNumber.length(); i++) {
            if (Character.isDigit(binNumber.charAt(i))) {
                int num = Integer.parseInt("" + binNumber.charAt(i));
                if (num == 0 || num == 1) {
                    onlyBin.append(binNumber.charAt(i));
                }
            }
        }
        return onlyBin.toString();
    }

    public static void replaceAll(String oldWord, String newWord, String filePath) {
    }
}
