/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
   Hide Hint #1  
So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one of the numbers say x, we are left with the two-sum problem at hand!
   Hide Hint #2  
For the two-sum problem, if we fix one of the numbers, say
x
, we have to scan the entire array to find the next number
y
which is
value - x
where value is the input parameter. Can we change our array somehow so that this search becomes faster?
   Hide Hint #3  
The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?


*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //  [-1, 0, 1, 2, -1, -4]
        Arrays.sort(nums);
        
        // [-4,-1,-1,0,1,2]
        List<List<Integer>> r = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            
            int j =i+1;
            int k = nums.length-1;
            
            while(j<k) {

                if(k<nums.length-1 && nums[k]==nums[k+1]) {
                    k--;
                    continue;
                }
                if(nums[i]+nums[j]+nums[k]>0) {
                    k--;
                } else if(nums[i]+nums[j]+nums[k]<0) {
                    j++;
                } else {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    r.add(li);
                    j++;
                    k--;
                }
            }
            
        }
        
        return r;
    }
}
