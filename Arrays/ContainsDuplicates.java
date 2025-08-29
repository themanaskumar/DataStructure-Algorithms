// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation: The element 1 occurs at the indices 0 and 3.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: All elements are distinct.

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true
import java.util.*;
public class ContainsDuplicates {
    boolean containsDuplicates(int[] nums){
        HashSet<Integer> st = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(st.contains(nums[i])){
                return true;
            }else{
                st.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int len = sc.nextInt();
        int[] nums = new int[len];
        System.out.print("Enter the array elements: ");
        for(int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }
        ContainsDuplicates solver = new ContainsDuplicates();
        boolean result = solver.containsDuplicates(nums);
        System.out.print("Result: " + result);
    }
}