package com.nitrous.leetcode.sudokuvalid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/submissions/
 * @author nitrousdigital
 *
 */
public class Solution {
    
    /**
     * O(N) where N is the number of cells in the grid.
     * 
     * Performs a single pass over the entire grid.
     * Allocates more memory (sqrt(N) * 3) sets
     * 
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // values found in each row
        List<Set<Character>> foundRows = new ArrayList<>(9);
        // values found in each column
        List<Set<Character>> foundCols = new ArrayList<>(9);
        // values found in each sub-grid
        List<Set<Character>> foundSubgrid = new ArrayList<>(9);
        for (int i = 0 ; i < 9; i++) {
            foundRows.add(new HashSet<Character>());
            foundCols.add(new HashSet<Character>());
            foundSubgrid.add(new HashSet<Character>());
        }
        
        // for (int row = 0; row < 9; row++) {
        //     for (int col = 0 ; col < 9; col++) {
        //         System.out.print(board[row][col]);
        //     }
        //     System.out.println();
        // }
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0 ; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                Character C = Character.valueOf(c);
                
                // validate row
                if (foundRows.get(row).contains(C)) {
                    // System.out.println("Invalid: Row " + (row + 1) + " already contains " + c);
                    return false;
                }
                foundRows.get(row).add(C);
                
                // validate col
                if (foundCols.get(col).contains(C)) {
                    // System.out.println("Invalid: Col " + (col + 1) + " already contains " + c);
                    return false;
                }
                foundCols.get(col).add(C);
                
                // validate subgrid
                int gridCol = col / 3;
                int gridRow = row / 3;
                int gridIdx = (gridRow * 3) + gridCol;
                if (foundSubgrid.get(gridIdx).contains(C)) {
                    // System.out.println("Invalid: SubGrid " + (gridIdx + 1) + " already contains " + c);
                    return false;
                }
                foundSubgrid.get(gridIdx).add(C);
            }
        }

        return true;  
    }
    
    /**
     * Fast for small boards.
     * Uses less memory.
     * 
     * Where N = number of cells: O(N * 3) == O(N)
     * 
     * @param board
     * @return
     */
    public boolean isValidSudokuSimple(char[][] board) {
        // check 3x3 groups
        for (int hGroup = 0; hGroup < 3; hGroup++) {
            for (int vGroup = 0; vGroup < 3; vGroup++) {
                // check group
                HashSet<Character> found = new HashSet<>();
                int yStart = vGroup * 3;
                int xStart = hGroup * 3;
                for (int y = yStart; y < yStart + 3; y++) {
                    for (int x = xStart; x < xStart + 3; x++) {
                        char c = board[y][x];
                        if (c != '.') {
                            Character C = Character.valueOf(c);
                            if (found.contains(C)) {
                                return false;
                            }
                            found.add(C);
                        }                      
                    }
                }
            }
        }
          
        // check rows
        for (int y = 0 ; y < board.length; y++) {
            HashSet<Character> found = new HashSet<>();
            for (int x = 0; x < 9; x++) {
               char c = board[y][x];
               if (c != '.') {
                    Character C = Character.valueOf(c);
                    if (found.contains(C)) {
                        return false;
                    }
                    found.add(C);
               }                      
            }
        }  
          
        // check cols
        for (int x = 0 ; x < 9; x++) {
            HashSet<Character> found = new HashSet<>();
            for (int y = 0; y < 9; y++) {
               char c = board[y][x];
               if (c != '.') {
                    Character C = Character.valueOf(c);
                    if (found.contains(C)) {
                        return false;
                    }
                    found.add(C);
               }                      
            }
        }  
        return true;  
      }    
}