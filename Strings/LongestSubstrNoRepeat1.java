// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.

// Note: Not the optimal solution, can be optimized.
import java.util.*;
public class LongestSubstrNoRepeat1 {
    int longestNoRepeat(String s) {
        Set<Character> st = new HashSet<>();
        int maxLen = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int len = 0;
            for(int j = i; j < n; j++){
                if(st.contains(s.charAt(j))) break;
                st.add(s.charAt(j));
                len++;
            }
            maxLen = Math.max(maxLen, len);
            st.clear();
        }
        return maxLen;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            LongestSubstrNoRepeat1 solver = new LongestSubstrNoRepeat1();
            int ans = solver.longestNoRepeat(str);
            System.out.println("Longest substring without repeating characters: " + ans);
        } catch (Exception e) {

        }
    }
}