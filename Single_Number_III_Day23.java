/*

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/


class Solution {
    public int[] singleNumber(int[] nums) {
        
        int a = 0;
        
        int b = 0;
        
        int temp = 0;
        
        for(int num: nums) {
            temp = temp^num;
        }
        
        // Identift First From Right.
        
        int mask = 1; // 001 // 010 // 100
        
        while((temp & mask)==0) {
            
            mask = mask << 1;
            
        }
        
        //010 mask temp 110
        
        for(int num: nums) {
            if((mask & num)==0) {
                a = a^num;
            } else {
                b= b^num;
            }
        }
        
        return new int[]{a,b};
        
        
        
    }
}
