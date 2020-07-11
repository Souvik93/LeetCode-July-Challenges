/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if(null == nums || nums.length == 0) {
            return results;
        }
        
        findSubsets(results,nums,0,new ArrayList<Integer>());
        
        return results;
    }
    
    private void findSubsets(List<List<Integer>> results, int[] nums, int startIndex, List<Integer> temp) {
        
        results.add(new ArrayList<Integer>(temp));
        
        // = [1,2,3]
        for(int i= startIndex;i<nums.length;i++) {
            temp.add(nums[i]);
            findSubsets(results,nums, i+1,temp);
            temp.remove(temp.size()-1);
            
        }
        
        
        
        
    }
}
