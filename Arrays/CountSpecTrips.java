/*
Leetcode 3583: Count Special Triplets
You are given an integer array nums.
A special triplet is defined as a triplet of indices (i, j, k) such that:
0 <= i < j < k < n, where n = nums.length
nums[i] == nums[j] * 2
nums[k] == nums[j] * 2
Return the total number of special triplets in the array.
Since the answer may be large, return it modulo 10^9 + 7.

Example 1:
Input: nums = [6,3,6]
Output: 1
Explanation: The only special triplet is (i, j, k) = (0, 1, 2), where:
nums[0] = 6, nums[1] = 3, nums[2] = 6
nums[0] = nums[1] * 2 = 3 * 2 = 6
nums[2] = nums[1] * 2 = 3 * 2 = 6

Example 2:
Input: nums = [0,1,0,0]
Output: 1
Explanation: The only special triplet is (i, j, k) = (0, 2, 3), where:
nums[0] = 0, nums[2] = 0, nums[3] = 0
nums[0] = nums[2] * 2 = 0 * 2 = 0
nums[3] = nums[2] * 2 = 0 * 2 = 0

Example 3:
Input: nums = [8,4,2,8,4]
Output: 2
Explanation: There are exactly two special triplets: (i, j, k) = (0, 1, 3)
nums[0] = 8, nums[1] = 4, nums[3] = 8
nums[0] = nums[1] * 2 = 4 * 2 = 8
nums[3] = nums[1] * 2 = 4 * 2 = 8
(i, j, k) = (1, 2, 4)
nums[1] = 4, nums[2] = 2, nums[4] = 4
nums[1] = nums[2] * 2 = 2 * 2 = 4
nums[4] = nums[2] * 2 = 2 * 2 = 4
*/
import java.util.*;
public class CountSpecTrips {
    static int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        long answer = 0; 
        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int currentRightCount = rightMap.get(num);
            if (currentRightCount == 1) {
                rightMap.remove(num);
            } else {
                rightMap.put(num, currentRightCount - 1);
            }
            long targetLong = (long) num * 2;
            if (targetLong <= Integer.MAX_VALUE && targetLong >= Integer.MIN_VALUE) {
                int target = (int) targetLong;
                if (leftMap.containsKey(target) && rightMap.containsKey(target)) {
                    long leftCount = leftMap.get(target);
                    long rightCount = rightMap.get(target);
                    long combinations = (leftCount * rightCount) % MOD;
                    answer = (answer + combinations) % MOD;
                }
            }
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        return (int) answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int res = specialTriplets(nums);
        System.out.println("Number of special triplets: " + res);
        sc.close();
    }
}