package com.nitrous.techidelight.maxcontinuoussequence;

import java.util.Arrays;

/*

Given a binary array, find the index of 0 to be replaced with 1 to get the maximum length sequence of continuous ones. The solution should return the index of first occurence of 0, when multiple continuous sequence of maximum length is possible.

Input : [0, 0, 1, 0, 1, 1, 1, 0, 1, 1]
Output: 7
Explanation: Replace index 7 to get the continuous sequence of length 6 containing all 1’s.

Input : [0, 1, 1, 0, 0]
Output: 0
Explanation: Replace index 0 or 3 to get the continuous sequence of length 3 containing all 1’s. The solution should return the first occurence.

Input : [1, 1]
Output: -1
Explanation: Invalid Input (all 1’s)

*/

public class MaxContinuousSequence {
    
    private static void test(int[] nums, int expected) {
        int actual = Solution.findIndexofZero(nums);
        System.out.println();
        if (actual != expected) {
            System.out.println("* Failed for input " + Arrays.toString(nums));
            System.out.println("\tExpected output -> " + expected);
            System.out.println("\tYour output -> " + actual);
        } else {
            System.out.println(Arrays.toString(nums) + " -> " + actual + " = Correct!");
        }        
    }
    
    public static void main(String[] args) {
        // Failed for Input [0, 1, 1, 0, 1, 1, 1, 0, 1, 1]
        // Expected output —> 3
        // Your output     —> 7
        test(new int[] {0, 1, 1, 0, 1, 1, 1, 0, 1, 1}, 3);
        
        
        // Failed for Input [0, 0, 1, 0, 1, 1, 1, 0, 1, 1]
        // Expected output —> 7
        // Your output     —> 3
        test(new int[] {0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, 7);
        
        // Failed for Input [1, 1, 1, 1, 0]
        // Expected output —> 4
        // Your output     —> 5
        test(new int[] {1, 1, 1, 1, 0}, 4);
        
        // Failed for Input [0]
        // Expected output —> 0
        // Your output     —> -1
        test(new int[] {0}, 0);

        // Failed for Input [0, 0]
        // Expected output —> 0
        // Your output     —> -1
        test(new int[] {0, 0}, 0);
        
    }
}
