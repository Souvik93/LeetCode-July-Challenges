/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        
        dfs(wordDict,s,new StringBuilder(),0, new boolean[s.length()+1],result);
        
        return result;
        
    }
    
    private void dfs(List<String> wordDict, String s, StringBuilder sb, int index, boolean[] invalid, List<String> result) {
        
        if(index==s.length()) {
            result.add(sb.toString());
            return ;
        }
        
        for(int i=index+1;i<=s.length();i++) {
            
            if(!invalid[i]) {
                
                if(wordDict.contains(s.substring(index,i))) {
                    
                    
                    int os = result.size();
                    
                    int ol = sb.length();
                    
                    if(ol != 0) {
                        sb.append(" ");
                    }
                    
                    sb.append(s.substring(index,i));
                    
                    dfs(wordDict,s,sb,i,invalid,result);
                    
                    if(os==result.size()) {
                        invalid[i] = true;
                    }
                    
                    sb.delete(ol,sb.length());
                    
                    
                    
                    
                }
                
                
             }
            
            
        }
        
    }
}
