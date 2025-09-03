// 35. Find Insert Position:
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4
 
import java.util.*;

public class FindInsertPos{
    int findPos(int nums[], int target){
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.print("Enter the array elements: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter target: ");
            int target = sc.nextInt();
            FindInsertPos solver = new FindInsertPos();
            int res = solver.findPos(arr, target);
            System.out.println("Position to insert target: " + res);
        } catch (Exception e) {
        }
    }
}