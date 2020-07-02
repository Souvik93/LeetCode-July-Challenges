/*

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        
        List<List<Integer>> results = new LinkedList<>();
        
        if(root == null) {
            return results;
        }
        
        q.add(root);
        
        while(q.size()>0) {
            int no = q.size();
            List<Integer> li = new LinkedList<>();
            for(int i=0;i<no;i++) {
                TreeNode nodeTemp = q.remove();
                li.add(nodeTemp.val);
                if(nodeTemp.left !=null) {
                    q.add(nodeTemp.left);
                }
                if(nodeTemp.right !=null) {
                    q.add(nodeTemp.right);
                }
                
            }
            results.add(0,li);
        }
        
        return results;

        
        
    }
}
