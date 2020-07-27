/*

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length !=postorder.length) {
            return null;
        }
        
        return builder(inorder,postorder,0,inorder.length-1,postorder.length-1);
        
    }
    
    private TreeNode builder(int[] inorder, int[] postorder,int start,int last, int index) {
        if(start>last) {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[index]);
        
        int i =0;
        while(inorder[last-i] != postorder[index]) {
            i++;
        }
        
        node.left = builder(inorder,postorder,start,last-i-1,index-i-1);
        
        node.right = builder(inorder,postorder,last-i+1,last,index-1);
        
        return node;
    }
}
