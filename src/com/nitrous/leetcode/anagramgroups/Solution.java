package com.nitrous.leetcode.anagramgroups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * @author nitrousdigital
 *
 */
public class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : strs) {
            String key = getKey(word);
            List<String> list = anagrams.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                anagrams.put(key, list);
            }
            list.add(word);
        }
        return new ArrayList<List<String>>(anagrams.values());
    }

    /**
     * Generate a key for the anagram by counting the frequency of each alphabetical
     * character in the word
     * 
     * @param word The word for which an anagram key is to be generated
     * @return The key for the specified anagram, generated by counting the
     *         frequency of each alphabetical character in the word
     */
    private static String getKey(String word) {
        int[] key = new int[26];
        for (int i = 0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 97;
            key[idx]++;
        }
        
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < key.length; i++) {
            buf.append(key[i]).append(";");
        }
        return buf.toString();
    }
    
//    /**
//     * Generate a key for the specified anagram by sorting the letters in the word.
//     */
//    private static String getKey(String word) {
//        char[] chars = word.toCharArray();
//        // The sorting algorithm is a Dual-Pivot Quicksort
//        // by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
//        // offers O(n log(n)) performance on all data sets, and is typically
//        // faster than traditional (one-pivot) Quicksort implementations.
//        Arrays.sort(chars);
//        return String.valueOf(chars);
//    }
}
