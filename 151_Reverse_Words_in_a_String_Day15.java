/*

Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Follow up:

For C programmers, try to solve it in-place in O(1) extra space.



*/

class Solution {
    public String reverseWords(String s) {
        // Approach 1
       /* if(s.length()==0) {
            return "";
        }
        
        String str[] = s.split(" "); 
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=str.length-1;i>=0;i--) {
            if(!str[i].equals("")) {
                sb.append(str[i]).append(" ");
            }
        }
        
        return sb.toString().trim(); */
        // Approach 2
        if(s.length()==0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int j=0;
        
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) !=' ') {
                j=i;
                i = s.lastIndexOf(" ",i);
                sb.append(s,i+1,j+1).append(" ");
            }
        }
        
        return sb.toString().trim();
        
        
        
        
    }
}
