// 3Sum: 
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Note: This is not the optimal solution but it is acceptable in leetcode. For optimal solution go to ThreeSumOptimal.java

import java.util.*;
public class ThreeSum1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> hashset = new HashSet<>();
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length; j++){
                int rem = nums[i]+nums[j] == 0 ? 0 : (-1*(nums[i] + nums[j]));
                if(st.contains(rem)){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], rem, nums[j]));
                    Collections.sort(temp);
                    hashset.add(temp);
                }
                else{
                    st.add(nums[j]);
                }
            }
            st.clear();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(hashset);
        return result;
    }

    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter array length: ");
            int len = sc.nextInt();
            int[] nums = new int[len];
            System.out.print("Enter the array elements: ");
            for (int i = 0; i < len; i++) {
                nums[i] = sc.nextInt();
            }
            ThreeSum1 solver = new ThreeSum1();
            List<List<Integer>> result = solver.threeSum(nums);
            System.out.println("Triplets with zero sum: ");
            for(List<Integer> row : result){
                for(Integer i : row){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}