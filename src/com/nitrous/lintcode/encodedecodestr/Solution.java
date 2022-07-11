package com.nitrous.lintcode.encodedecodestr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder buf = new StringBuilder();
        for (String s : strs) {
            buf.append(s.length()).append(";").append(s);
        }
        return buf.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < str.length(); ) {
            // read length
            StringBuilder lenStr = new StringBuilder();
            char c;
            while ( (c = str.charAt(i)) != ';' ) {
                lenStr.append(c);
                i++;
            }
            if (lenStr.length() > 0) {
                // skip past delimeter
                i++;
                // decode the length
                Integer len = Integer.parseInt(lenStr.toString());
                // extract the string content
                result.add(str.substring(i, i + len));
                i += len;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] words = {"lint","code","love","you"};
        List<String> test = Arrays.asList(words);
        
        Solution sol = new Solution();
        String encoded = sol.encode(test);
        List<String> decoded = sol.decode(encoded);
        if (!Arrays.equals(words, decoded.toArray())) {
            System.err.println("Failed: Expected " + words + " found " + decoded);
        } else {
            System.out.println("Pass!");
        }
    }
}
