// Product of Array Except Self:
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

import java.util.*;
public class ProductExceptSelf {
    int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        Map<Integer, Integer> suffix = new HashMap<>();
        int result[] = new int[nums.length];
        int product = 1;
        prefix.put(0, 1);
        for(int i = 1; i < nums.length; i++){
            product = product*nums[i-1];
            prefix.put(i, product);
        }
        product = 1;
        suffix.put(nums.length-1, 1);
        for(int i = nums.length-2; i >= 0; i--){
            product*=nums[i+1];
            suffix.put(i, product);
        }
        for(int i = 0; i < nums.length; i++){
            product = prefix.get(i)*suffix.get(i);
            result[i] = product;
        }
        return result;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the array length: ");
            int len = sc.nextInt();
            int[] nums = new int[len];
            System.out.print("Enter array elements: ");
            for(int i = 0; i < len; i++){
                nums[i] = sc.nextInt();
            }
            ProductExceptSelf solver = new ProductExceptSelf();
            int[] result = solver.productExceptSelf(nums);
            System.out.print("Result: ");
            for(int i = 0; i < result.length; i++){
                System.out.print(result[i]+" ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
