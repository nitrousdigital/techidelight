package com.nitrous.techidelight.maxcontinuoussequence;

public class Solution
{
    enum State {
        // find the beginning of the next sequence of 1s
        FIND_START,
        
        // find the end of the current sequence of 1s
        FIND_END
    }
    private static class SearchState {
        State state = State.FIND_START;
        
        // longest combined sequence length found so far
        int maxSequenceLen = 0;
        
        // index of the zero to be replaced to form the longest sequence of 1s
        int result = -1;
        
        // inclusive bounds of the preceding sequence
        int prevSequenceStartIdx = -1;
        int prevSequenceEndIdx = -1;
        int prevSequenceLen = -1;
        
        // inclusive bounds of the most recent sequence 
        int sequenceStartIdx = -1;
        int sequenceEndIdx = -1;
        int sequenceLen = -1;
        
        /**
         * Close out the current sequence
         */
        private void closeSequence(int[] nums, int i) {
            // try combining with the preceding sequence
            if (prevSequenceEndIdx != -1 && prevSequenceEndIdx + 2 == sequenceStartIdx) {
                // there is a preceding sequence and it is separated by only 1 zero.
                // measure combined length of current sequence
                // and preceding sequence to determine whether we have a new result
                int combinedLen = prevSequenceLen + sequenceLen + 1;
                if (combinedLen > maxSequenceLen) {
                    maxSequenceLen = combinedLen;
                    result = sequenceStartIdx - 1;
                }
            } else {
                // there is not a preceding sequence that can join the current sequence
                // so check if we can extend the current sequence by prepending or appending a 1
                if (sequenceLen + 1 > maxSequenceLen) {
                    if (sequenceStartIdx > 0) {
                        // prepend 1
                        maxSequenceLen = sequenceLen + 1;
                        result = sequenceStartIdx - 1;
                    } else if (i < nums.length && nums[i] == 0 && 
                               (i + 1 == nums.length || nums[i + 1] == 0)) {
                        // we can append the 1 if 
                        // the current sequence is followed by a single zero and end of nums array 
                        // OR followed by two zeros
                        maxSequenceLen = sequenceLen + 1;
                        result = i;
                    } 
                }
                
            }
            
            // begin searching for the next sequence
            prevSequenceStartIdx = sequenceStartIdx;
            prevSequenceEndIdx = sequenceEndIdx;
            prevSequenceLen = sequenceLen;
            
            sequenceLen = 0;
            
            // check length of combining 2 preceding sequences
            // begin searching for the beginning of the next sequence
            // after a zero separator.
            state = State.FIND_START;                   
        }
        
        /**
         * Terminate the current sequence of 1s
         * @param nums The number array being processed
         * @param i The index into nums currently being processed 
         */
        public void onFoundSequenceEnd(int[] nums, int i) {
            // found the end of the current sequence
            sequenceEndIdx = i - 1;
            sequenceLen = (i - sequenceStartIdx);
            
            closeSequence(nums, i);
        }
        
        /**
         * Begin searching for the end of the sequence starting at the specified index
         */
        public void onFoundSequenceStart(int i) {
            // we have just found the first 1 of a sequence
            sequenceStartIdx = i;
            sequenceEndIdx = i;
            sequenceLen = 1;
            state = State.FIND_END;
        }
        
        /**
         * Found another 1 to append to the current sequence
         */
        public void onContinueFindEnd(int i) {
            sequenceEndIdx = i;
            sequenceLen++;
        }
        
        /**
         * Close out the current sequence since we have reached the end of the nums array
         */
        public void onFinish(int[] nums) {
            if (state == State.FIND_END) {
                closeSequence(nums, nums.length);
            }
    
        }
    }
    
    public static int findIndexofZero(int[] nums)
    {
        // when the sequence contains all zeros, we can substitute the first zero
        // with a 1 to produce a max length of 1.
        boolean isAllZeros = nums.length > 0;
        
        SearchState searchState = new SearchState();
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (searchState.state == State.FIND_END) {
                    searchState.onFoundSequenceEnd(nums, i);
                }
            } else {
                isAllZeros = false;
                switch(searchState.state) {
                case FIND_START:
                    searchState.onFoundSequenceStart(i);
                    break;
                    
                case FIND_END:
                    // we havent reached the end of the sequence yet
                    // so move the end pointer for the current sequence
                    searchState.onContinueFindEnd(i);
                    break;
                }
            }
        }
        
        // close out sequence
        searchState.onFinish(nums);
        
        // special case - when all zeros
        // return a sequence of length 1 by substituting the first zero
        // of the list with a 1
        if (isAllZeros) {
            return 0;
        }
        
        return searchState.result;
    }
}