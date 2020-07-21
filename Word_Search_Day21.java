/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

*/

class Solution {
    public boolean exist(char[][] board, String word) {
        
        char[] c = word.toCharArray();
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(c[0] == board[i][j] && dfs(board,i,j,0,c)) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    
    private boolean dfs(char[][] board,int i, int j,int curr,char[] cword) {
        
        if(curr==cword.length) {
            return true;
        }
        
        if(i<0 || j<0 || j>=board[0].length || i>= board.length || board[i][j] != cword[curr]) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] ='#';
        
        boolean answer = dfs(board,i,j+1,curr+1,cword) || dfs(board,i+1,j,curr+1,cword) || dfs(board,i-1,j,curr+1,cword) || dfs(board,i,j-1,curr+1,cword);
        
        board[i][j] = temp;
        
        return answer;
        
    }
}
