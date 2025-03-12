package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfCoinsRequired {

    public static void main(String[] args) {
        int[] coinArray = {1, 2, 5, 10};
        var coinMap = minimumNumberOfCoinsRequires(coinArray, 99);
        System.out.println(coinMap);
    }

    private static Map<Integer, Integer> minimumNumberOfCoinsRequires(int[] coinArray, int amount) {
        Map<Integer, Integer> coinMap = new HashMap<>();
        var sortedArray = Arrays.stream(coinArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(number -> number)
                .toArray();

        for (int i=0; i<sortedArray.length; i++) {
            int coinValue = sortedArray[i];
            if (amount >= coinValue) {
                int numberOfCoins = amount / coinValue;
                amount %= coinValue;
                coinMap.put(coinValue, numberOfCoins);
            }
        }

        return coinMap;
    }
}
