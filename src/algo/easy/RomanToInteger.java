package algo.easy;

import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> mapOfRomanToInt = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for(int i =0; i<length; i++) {
            int charAtI = mapOfRomanToInt.get(s.charAt(i));
            int charAtJ = 0;
            if(i+1 < length){
                charAtJ = mapOfRomanToInt.get(s.charAt(i + 1));
            }

            if(charAtI<charAtJ) {
                result = result + (charAtJ-charAtI);
                i++;
            } else  {
                result = result + charAtI;
            }
        }
        return result;
    }
}
