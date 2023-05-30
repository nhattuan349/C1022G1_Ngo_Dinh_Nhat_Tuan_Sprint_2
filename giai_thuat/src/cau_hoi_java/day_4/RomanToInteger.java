package cau_hoi_java.day_4;


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String roman) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int currValue = romanValues.get(c);

            if (currValue >= prevValue) {
                result += currValue;
            } else {
                result -= currValue;
            }

            prevValue = currValue;
        }

        return result;
    }

    public static void main(String[] args) {
        String romanNumeral = "MCXIV";
        int integer = romanToInt(romanNumeral);
        System.out.println("Roman numeral: " + romanNumeral);
        System.out.println("Integer value: " + integer);
    }
}
