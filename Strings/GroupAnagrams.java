// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Explanation: There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

import java.util.*;
public class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String s:strs){
            int count[] = new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return (new ArrayList<>(res.values()));
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter array length: ");
            int len = sc.nextInt();
            String[] strs = new String[len];
            System.out.print("Enter strings seperated by whitespaces: ");
            for(int i = 0; i < len; i++){
                strs[i] = sc.next();
            }
            GroupAnagrams solver = new GroupAnagrams();
            List<List<String>> ans = solver.groupAnagrams(strs);
            System.out.println("Answer: " + ans);

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}