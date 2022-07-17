package com.nitrous.leetcode.blind75.binary.hammingweight;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int x = n & 1;
            if (x == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int input = Long.valueOf("11111111111111111111111111111101", 2).intValue();
        int actual = new Solution().hammingWeight(input);
        int expected = 31;
        if (actual == expected) {
            System.out.println("Correct!");
        } else {
            System.err.println("Incorrect! Expected "+expected+" But Got "+actual+" for " + input);
        }
        
    }
}
