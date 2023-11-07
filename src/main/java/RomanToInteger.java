import java.util.HashMap;

/**
 * Created by Prasada Rao on 11/10/21 11:50 AM
 *
 * <a href="https://leetcode.com/problems/roman-to-integer/">13. Roman to Integer</a>
 **/
public class RomanToInteger {

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    public int romanToInt(String s) {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int index = 0;
        int number = 0;

        while (index < s.length()) {
            if (index != s.length() - 1 && map.containsKey(s.substring(index, index + 2))) {
                number += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                number += map.get(String.valueOf(s.charAt(index)));
                index++;
            }
        }
        return number;
    }

    public int romanToInt1(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char next = ' ';
            if (i != s.length() - 1) {
                next = s.charAt(i + 1);
            }
            switch (current) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'C':
                    if (next == 'M') {
                        result += 900;
                        i++;
                    } else if (next == 'D') {
                        result += 400;
                        i++;
                    } else {
                        result += 1000;
                    }
                    break;
                case 'X':
                    if (next == 'C') {
                        result += 90;
                        i++;
                    } else if (next == 'L') {
                        result += 40;
                        i++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'I':
                    if (next == 'X') {
                        result += 9;
                        i++;
                    } else if (next == 'V') {
                        result += 4;
                        i++;
                    } else {
                        result += 1;
                    }
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("III " + new RomanToInteger().romanToInt("III"));
        System.out.println("IV " + new RomanToInteger().romanToInt("IV"));
        System.out.println("IX " + new RomanToInteger().romanToInt("IX"));
        System.out.println("LVIII " + new RomanToInteger().romanToInt("LVIII"));
        System.out.println("MCMXCIV " + new RomanToInteger().romanToInt("MCMXCIV"));
        System.out.println("DCXXI " + new RomanToInteger().romanToInt("DCXXI"));
    }
}
