package com.nitrous.techidelight.twosum;

import java.util.Arrays;
import java.util.Objects;

/*

Given an unsorted integer array, find a pair with the given sum in it.

• Each input can have multiple solutions. The output should match with either one of them.

Input : nums[] = [8, 7, 2, 5, 3, 1], target = 10
Output: (8, 2) or (7, 3)

• The solution can return pair in any order. If no pair with the given sum exists, the solution should return null.

Input : nums[] = [5, 2, 6, 8, 1, 9], target = 12
Output: null

*/
public class TwoSum {
    private static void test(int[] nums, int target, Pair<Integer, Integer>... expected) {
        Pair<Integer, Integer> actual = Solution.findPair(nums, target);
        System.out.println();
        boolean hasExpected = false;
        if (expected == null || expected.length == 0) {
            hasExpected = actual == null;
        } else {
            for (Pair<Integer, Integer> ex : expected) {
                if (Objects.equals(actual, ex)) {
                   hasExpected = true;
                   break;
                }
            }
        }
        
        if (!hasExpected) {
            System.out.println("* Failed for input " + Arrays.toString(nums));
            System.out.println("\tExpected output -> " + Arrays.toString(expected));
            System.out.println("\tYour output -> " + actual);
        } else {
            System.out.println(Arrays.toString(nums) + " -> " + actual + " = Correct!");
        }        
    }
    
    public static void main(String[] args) {
        // Input : nums[] = [8, 7, 2, 5, 3, 1], target = 10
        // Output: (8, 2) or (7, 3)
        test(new int[] {8, 7, 2, 5, 3, 1}, 10, 
                Pair.of(8,2), Pair.of(7, 3),
                Pair.of(2,8), Pair.of(3, 7));

        // Input : nums[] = [5, 2, 6, 8, 1, 9], target = 12
        // Output: null
        test(new int[] {5, 2, 6, 8, 1, 9}, 12);
    }
}
