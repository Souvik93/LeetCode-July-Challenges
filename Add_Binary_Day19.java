/*

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.


*/Add Binary




class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sbu = new StringBuilder();
        
        int sa= a.length()-1;
        int sb = b.length() -1 ;
        
        int carry = 0;
        
        while(sa>=0 || sb >=0) {
            
            if(sa>=0) {
                carry = carry+ a.charAt(sa--) - '0';
            }
            
            if(sb>=0) {
                carry = carry+ b.charAt(sb--) - '0';
            }
            
            // carry = 2;
            
            // 0 
            
            // Carry = 1;
            
            // 1+1 = 2
            
            // 00 -> sbu
            
            // 1
            
            
            
            sbu.append(carry%2);
            carry = carry/2;
            
            
        }
        
        if(carry>0) {
            sbu.append(carry);
        }
        
        // sbu -> 001`
        
        return sbu.reverse().toString();
        
    }
}
