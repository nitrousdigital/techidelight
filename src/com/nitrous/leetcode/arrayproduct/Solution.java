package com.nitrous.leetcode.arrayproduct;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author nitrousdigital
 *
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // calculate left-hand (prefix) product for each element
        int total = 1;
        // there is no left-hand prefix for the first element
        // so set to 1 so that we dont get a result of zero
        // when we multiply by the right-hand product
        result[0] = 1;
        for (int i = 1 ; i < nums.length; i++) {
            total *= nums[i - 1];
            result[i] = total; 
        }
        // nums = {1, 2, 3, 4}
        // result]{0, 1, 2, 6}

        // calculate right-hand (suffix) product and combine
        // with the left hand product already calculated for each element.
        int p = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            p *= nums[i + 1];
            result[i] *= p;            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {1,2,3,4};
        int[] expected = {24,12,8,6};
        int[] output = s.productExceptSelf(input);
        
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(output));
        if (Arrays.equals(output, expected)) {
            System.err.println("Correct!");
        } else {
            System.err.println("Expected: "+Arrays.toString(expected));
        }
            
    }
}
