package com.nitrous.leetcode.romantoint;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> values = new HashMap<>();
    static {
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = values.get(c);
            
            // check for subtraction
            // I can be placed before V (5) and X (10) to make 4 and 9. 
            // X can be placed before L (50) and C (100) to make 40 and 90. 
            // C can be placed before D (500) and M (1000) to make 400 and 900.
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                switch (c) {
                    // I can be placed before V (5) and X (10) to make 4 and 9. 
                    case 'I' : {
                        switch (next) {
                            // I can be placed before V (5) to make 4
                            case 'V': 
                                value = 4; 
                                i++;
                                break;
                                
                            // I can be placed before and X (10) to 9 
                            case 'X':
                                value = 9;
                                i++;
                                break;
                        }
                        break;                                                
                    }

                    // X can be placed before L (50) and C (100) to make 40 and 90. 
                    case 'X': {                                            
                        switch (next) {
                            // X can be placed before L (50) to make 40
                            case 'L':
                                value = 40;
                                i++;
                                break;

                            // X can be placed before C (100) to make 90
                            case 'C':
                                value = 90;
                                i++;
                                break;
                        }
                        break;
                    }
                        
                    // C can be placed before D (500) and M (1000) to make 400 and 900.
                    case 'C': {
                        switch (next) {
                            // C can be placed before D (500) to make 400
                            case 'D': 
                                value = 400;
                                i++;
                                break;
                                
                            // C can be placed before M (1000) to make 900
                            case 'M':
                                value = 900;
                                i++;
                                break;
                        }
                        break;
                    }
                
                }
            }
            sum += value;
        }
        return sum;
    }
}