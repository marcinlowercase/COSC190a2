package cosc190_assignment_2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void replaceAll(String oldWord, String newWord, String filePath) throws IOException {

        File file = new File(filePath);

        if (file.isFile()){
            if (file.getName().contains(".txt")){
                //replace word
                Path path = Paths.get(filePath);
                try (Stream<String> lineInFile = Files.lines(path)){
                    List<String> lineList = lineInFile.map(line -> line.replaceAll(oldWord, newWord)).collect(Collectors.toList());
                    Files.write(path, lineList, StandardCharsets.UTF_8);
                }
            }
        } else {
            // create an array of File obj of subFolder and .txt file
            File[] validFile = file.listFiles(RecursiveMethods::validFile);
            for (File f : Objects.requireNonNull(validFile)){
                replaceAll(oldWord, newWord, f.getAbsolutePath());
            }
        }

    }
    private static boolean validFile(File file){
        if (file.isFile()){
            return file.getName().endsWith(".txt");
        } else {
            return true;
        }
    }
}


