// Trapping Rain Water: (Approach 1 using prefix and suffix)
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:
// Input: height = [4,2,0,3,2,5]
// Output: 9

import java.util.*;
public class TrapRain1{
    public int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int[] prefix = new int[n];
        int suffix[] = new int[n];
        prefix[0] = height[0];
        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }
        suffix[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i]=Math.max(suffix[i+1], height[i]);
        }
        for(int i = 0; i < n-1; i++){
            int leftMax = prefix[i], rightMax = suffix[i];
            if(height[i] < leftMax && height[i] < rightMax){
                total+=(Math.min(leftMax, rightMax)-height[i]);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int len = sc.nextInt();
            int[] nums = new int[len];
            System.out.print("Enter the array elements: ");
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextInt();
            }
            TrapRain1 solver = new TrapRain1();
            int trappedWater = solver.trap(nums);
            System.out.println("Total trapped water = " + trappedWater);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}