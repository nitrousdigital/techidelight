package com.nitrous.leetcode.inttoroman;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder solution = new StringBuilder();
        
        // thousands
        if (num >= 1000) {
            int thousands = num / 1000;
            num = num % 1000;
            for (int i = 0 ; i < thousands; i++) {
                solution.append("M");            
            }            
        }
        
        // hundreds
        if (num >= 100) {
            int hundreds = num / 100;
            num = num % 100;
            // C can be placed before D (500) and M (1000) to make 400 and 900.
            if (hundreds == 9) {
                // C can be placed before M (1000) to make 900.
                solution.append("CM");
                hundreds -= 9;
            } else if (hundreds >= 5 && hundreds <= 8) {
                // D is 500
                solution.append("D");
                hundreds -= 5;                
            } else if (hundreds == 4) {
                // C can be placed before D (500) to make 400.
                solution.append("CD");
                hundreds -= 4;
            } 
            for (int i = 0 ; i < hundreds; i++) {
                solution.append("C");
            }
            
        }
        
        // tens
        if (num >= 10) {
            int tens = num / 10;
            num = num % 10;
            // X can be placed before L (50) and C (100) to make 40 and 90. 
            if (tens == 9) {
                // X can be placed before C (100) to make 90. 
                solution.append("XC");
                tens -= 9;
            } else if (tens >= 5) {
                // L is 50
                solution.append("L");
                tens -= 5;
            } else if (tens == 4) {
                // X can be placed before L (50) to make 40
                solution.append("XL");
                tens -= 4;
            } 
            for (int i = 0 ; i < tens; i++) {
                solution.append("X");
            }                
            
        }
        
        // units
        while (num > 0) {
            if (num == 9) {
                // I can be placed before X (10) to 9. 
                solution.append("IX");    
                num -= 9;
            }
            if (num >= 5 && num <= 8) {
                solution.append("V");
                num -= 5;
                while (num > 0) {
                    solution.append("I");
                    num--;
                }
            }
            if (num == 4) {
                // I can be placed before V (5) to make 4. 
                solution.append("IV");
                num -= 4;
            }
            if (num < 4) {
                while (num > 0) {
                    solution.append("I");
                    num--;
                }
            }
        }
        
        return solution.toString();
    }
}