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
public class TrapRain2{
    public int trap(int[] height) {
        int total = 0, leftMax = 0, rightMax = 0, n = height.length;
        int l = 0, r = n-1;
        while(l < r){
            if(height[l] <= height[r]){
                if(leftMax > height[l])
                    total += (leftMax-height[l]);
                else
                    leftMax = height[l];
                l++;
            }else{
                if(rightMax > height[r])
                    total += (rightMax-height[r]);
                else
                    rightMax = height[r];
                r--;
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
            TrapRain2 solver = new TrapRain2();
            int trappedWater = solver.trap(nums);
            System.out.println("Total trapped water = " + trappedWater);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}