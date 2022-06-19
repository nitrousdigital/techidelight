package com.nitrous.leetcode.longestsubstring;

import java.util.HashSet;

public class Solution {
    /**
     * A sliding window approach
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {        
        int longest = 0;
        int wordStart = 0;
        int wordEnd = 0;
        HashSet<Character> seen = new HashSet<Character>();
        while (wordEnd < s.length()) {
            char c = s.charAt(wordEnd);
            while (seen.contains(c) && wordStart < wordEnd) {
                seen.remove(s.charAt(wordStart));
                wordStart++;
            }
            seen.add(c);
            longest = Math.max(seen.size(), longest);
            
            wordEnd++;
        }

        return longest;
    }
}
