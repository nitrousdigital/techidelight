package com.nitrous.leetcode.grind75.insertinterval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/insert-interval/
 * @author nitrousdigital
 *
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // handle case where intervals is empty
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        
        // if new interval entirely precedes the first interval
        // then simply create and return a new array
        if (intervals[0][0] > newInterval[1]) {
            int[][] result = new int[intervals.length + 1][];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            return result;
        }

        // if the new interval entirely follows the last interval
        // then simply create and return a new array
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            int[][] result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, intervals.length);
            result[result.length - 1] = newInterval;
            return result;
        }
        
        // handle inline insertion or overlap
        int i = 0;
        ArrayList<int[]> result = new ArrayList<>();

        // add intervals that entirely precede the new interval
        while (intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }        
        
        if (intervals[i][0] > newInterval[1]) {
            // no overlap, so just insert
            result.add(newInterval);
        } else {
            // handle merges
            int start = Math.min(intervals[i][0],  newInterval[0]);
            int end = Math.max(intervals[i][1],  newInterval[1]);
            i++;
            while (i < intervals.length &&
                    (intervals[i][0] <= start ||
                     intervals[i][0] <= end ||
                     intervals[i][1] <= start ||
                     intervals[i][1] <= end)) {
                end = Math.max(intervals[i][1],  newInterval[1]);
                i++;
            }
            result.add(new int[] {start, end});
        }
        
        // add remaining non-overlapping intervals
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }
        
        return result.toArray(new int[result.size()][]);
        
    }
    
    public static void main(String[] args) {
        int[][] inputIntervals = {{1,5}};
        int[] insert = {2,3};
        int[][] expected = new int[][]{{1,5}};
        
//        int[][] inputIntervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] insert = new int[] {4,8};
//        int[][] expected = new int[][] {{1,2},{3,10},{12,16}};
        
        int[][] actual = new Solution().insert(inputIntervals, insert);
        
        System.out.println("Input:\n" + toString(inputIntervals) + "\nInsert:\n" + Arrays.toString(insert));
        if (isEqual(actual,expected)) {
            System.out.println("Correct! " + toString(actual));
        } else {
            System.err.println("Incorrect!\nExpected:\n" + toString(expected)+ "\nBut Got:\n" + toString(actual));
        }
    }
    
    private static boolean isEqual(int[][] expected, int[][] actual) {
        if (expected.length == actual.length) {
            for (int i = 0; i < expected.length; i++) {
                if (!Arrays.equals(expected[i], actual[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static String toString(int[][] arr) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0 ; i < arr.length; i++) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(Arrays.toString(arr[i]));
        }
        return buf.toString();
    }
}
