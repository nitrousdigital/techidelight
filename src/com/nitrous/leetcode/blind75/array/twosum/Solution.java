package com.nitrous.leetcode.blind75.array.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * @author nitrousdigital
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // lookup from needed balance to index into nums array        
        Map<Integer, Integer> need = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length; i++) {
           int num = nums[i];
           int balance = target - num;
           if (need.containsKey(num)) {
               return new int[] {need.get(num), i};
           }
           need.put(balance, i);               
         }
        return null;
    }
}
