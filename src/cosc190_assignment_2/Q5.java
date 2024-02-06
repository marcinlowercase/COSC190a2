package cosc190_assignment_2;

import java.util.Arrays;
import java.util.function.Function;

public class Q5 {

    public static int doOperation(Function<Integer[], Integer> operation, Integer[] aVals) {
        return operation.apply(aVals);
    }

    public static void main(String[] args) {
        Integer[] aVals = {2, 7, 10, 1};

        System.out.printf("The first value is %d\n", doOperation(arr -> arr[0], aVals));
        System.out.printf("The Last value is %d\n", doOperation(arr -> arr[arr.length -1], aVals));
        System.out.printf("The Average value is %d\n", doOperation(arr -> (int) Arrays.stream(arr).mapToInt(Integer::intValue).average().getAsDouble(), aVals));

    }

}
