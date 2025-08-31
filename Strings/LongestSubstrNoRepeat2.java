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

// Note: This is the optimized solution.
import java.util.*;
public class LongestSubstrNoRepeat2 {
    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = 0;
        while(r < s.length()){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l){
                l = map.get(s.charAt(r))+1;
            }
            maxLen = Math.max(maxLen, r-l+1);
            map.put(s.charAt(r),r);
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            LongestSubstrNoRepeat2 solver = new LongestSubstrNoRepeat2();
            int ans = solver.lengthOfLongestSubstring(str);
            System.out.println("Longest substring without repeating characters: " + ans);
        } catch (Exception e) {

        }
    }
}