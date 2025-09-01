// Valid Parantheses: 
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

// Example 4:
// Input: s = "([])"
// Output: true

// Example 5:
// Input: s = "([)]"
// Output: false

import java.util.*;
public class ValidParantheses {
    boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stk.push(c);
            }
            else{
                if(stk.isEmpty()) return false;
                char t = stk.pop();
                if((c == ')' && t != '(') || (c == '}' && t != '{') || (c == ']' && t != '[')) return false;
            }
        }
        return stk.isEmpty();
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Enter a string of parantheses () [] {}: ");
            String str = sc.next();

            ValidParantheses solver = new ValidParantheses();
            boolean ans = solver.isValid(str);
            System.out.println("Answer: " + ans);
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
