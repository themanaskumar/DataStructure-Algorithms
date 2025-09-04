// Merge Two Sorted Arrays:
// Given two arrays nums1 and nums2 of lengths m and n respectively you have you return an array of size m+n which contains the elements of both nums1 and nums2 in the sorted fashion.

//Example 1:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
// Example 2:

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]
// Explanation: The arrays we are merging are [1] and [].
// The result of the merge is [1].
// Example 3:

// Input: nums1 = [0], m = 0, nums2 = [1], n = 1
// Output: [1]
// Explanation: The arrays we are merging are [] and [1].
// The result of the merge is [1].

import java.util.*;
public class MergeTwoSortedArrays {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k =0;
        int[] res = new int[m+n];
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < m){
            res[k] = nums1[i];
            k++;
            i++;
        }
        while(j < n){
            res[k] = nums2[j];
            k++;
            j++;
        }
        return res;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int m, n;
            System.out.print("Enter size of first array: ");
            m = sc.nextInt();
            System.out.print("Enter size of second array: ");
            n = sc.nextInt();
            int[] nums1 = new int[m];
            int nums2[] = new int[n];
            System.out.print("Enter first array: ");
            for(int i = 0; i < m; i++){
                nums1[i] = sc.nextInt();
            }
            System.out.print("Enter second array: ");
            for(int i = 0; i < n; i++){
                nums1[i] = sc.nextInt();
            }
            MergeTwoSortedArrays solver = new MergeTwoSortedArrays();
            int res[] = solver.merge(nums1, m, nums2, n);
            System.out.print("Result: ");
            for(int i : res){
                System.out.print(i+ " ");
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
