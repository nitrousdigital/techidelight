package com.nitrous.leetcode.inttoroman;

public class IntToRoman {
    private static void test(int input, String expected) {
        Solution sol = new Solution();
        String actual = sol.intToRoman(input);
        System.out.println();
        if (!expected.equals(actual)) {
            System.out.println("* Failed for input " + input);
            System.out.println("\tExpected output -> " + expected);
            System.out.println("\tYour output -> " + actual);
        } else {
            System.out.println(input + " -> " + actual + " = Correct!");
        }        
    }
    
    public static void main(String[] args) {
        int[] input = {
                3, 58, 1994, 3045, 60, 400, 600
        };
        String[] expected = {
                "III", "LVIII", "MCMXCIV", "MMMXLV", "LX", "CD", "DC" 
        };
        for (int i = 0 ; i < input.length; i++) {
            test(input[i], expected[i]);
        }
    }
}
