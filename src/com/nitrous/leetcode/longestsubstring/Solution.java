package com.nitrous.leetcode.longestsubstring;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {        
        int longest = 0;
        for (int wordStart = 0 ; wordStart < s.length(); wordStart++) {
            HashSet<Character> seen = new HashSet<Character>();
            for (int wordEnd = wordStart; wordEnd < s.length(); wordEnd++) {
                char c = s.charAt(wordEnd);
                if (!seen.add(c)) {
                    // duplicate character found
                    break;
                }
            }
            longest = Math.max(seen.size(), longest);
        }
        return longest;
    }
}
