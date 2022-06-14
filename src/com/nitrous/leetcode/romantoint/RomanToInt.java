package com.nitrous.leetcode.romantoint;

public class RomanToInt {
    private static void test(String input, int expected) {
        Solution sol = new Solution();
        int actual = sol.romanToInt(input);
        System.out.println();
        if (actual != expected) {
            System.out.println("* Failed for input " + input);
            System.out.println("\tExpected output -> " + expected);
            System.out.println("\tYour output -> " + actual);
        } else {
            System.out.println(input + " -> " + actual + " = Correct!");
        }        
    }
    
    public static void main(String[] args) {
        String[] input = {
                "III", "LVIII", "MCMXCIV" 
        };
        int[] expected = {
                3, 58, 1994
        };
        for (int i = 0 ; i < input.length; i++) {
            test(input[i], expected[i]);
        }
    }
}
