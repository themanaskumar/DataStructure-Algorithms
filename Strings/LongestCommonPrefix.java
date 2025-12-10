/*
Leetcode 14: Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
import java.util.*;
public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs){
        StringBuilder st = new StringBuilder("");
        Arrays.sort(strs);
        for(int i = 0; i < strs[0].length(); i++){
            if(strs[0].charAt(i) != strs[strs.length-1].charAt(i)) break;
            st.append(strs[0].charAt(i));
        }
        return st.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        if(n <= 0){
            System.out.println("The string array is empty.");
            sc.close();
            return;
        }
        String[] strs = new String[n];
        System.out.print("Enter the strings: ");
        for(int i = 0; i < n; i++){
            strs[i] = sc.next();
        }
        String ans = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + ans);
        sc.close();
    }
}