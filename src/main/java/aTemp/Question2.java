package aTemp;

import java.util.Arrays;
import java.util.OptionalInt;

public class Question2 {
    public static void main(String[] args) {
    String[] currentMakingOrders = new String[10];

        for (int i = 0; i < currentMakingOrders.length / 2; i++) {
            currentMakingOrders[i] = "someText" + i;
        }
/*        for (String temp:
             currentMakingOrders) {
            System.out.println(temp);
        }*/

        int[] timeToMakeOrder = new int[currentMakingOrders.length];
        OptionalInt min;
        int temp = 0;
        while (Arrays.stream(currentMakingOrders).filter(e -> e != null).count() > 0 && temp < 1) {
            timeToMakeOrder = Arrays.stream(currentMakingOrders)
                    .filter(e -> e != null).mapToInt(e -> e.charAt(3)).toArray();
            if (Arrays.stream(timeToMakeOrder).filter(e -> e > 0).count() > 0) {
                min = Arrays.stream(timeToMakeOrder).min();
                System.out.println(min);
            }
            for (int i = 0; i < currentMakingOrders.length; i++) {
                System.out.println(currentMakingOrders[i]);
            }
            temp++;
        }
    }
}
