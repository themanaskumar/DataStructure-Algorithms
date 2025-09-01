// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

import java.util.*;
public class ValidAnagrams{
    boolean isValidAnagram(String s, String t){
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                int val1 = map1.getOrDefault(s.charAt(i), 0) +1;
                int val2 = map2.getOrDefault(t.charAt(i), 0) +1;
                map1.put(s.charAt(i), val1);
                map2.put(t.charAt(i), val2);
            }
            for(int i = 0; i < s.length(); i++){
                if(!map1.get(s.charAt(i)).equals(map2.getOrDefault(s.charAt(i), 0))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter first string: ");
            String str1 = sc.next();
            System.out.print("Enter second string: ");
            String str2 = sc.next();
            ValidAnagrams solver = new ValidAnagrams();
            boolean ans = solver.isValidAnagram(str1, str2);
            System.out.println("Answer: " + ans);
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}