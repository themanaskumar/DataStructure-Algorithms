// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// Example 1:
// Input: nums = [1,2,0]
// Output: 3
// Explaination: 3 is missing after 0, 1, and 2.

// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.

import java.util.*;
public class FirstMissingPositive {
    public int findFirstPositiveMissing(int[] arr){
        Arrays.sort(arr);
        int i = 0;
        while(arr[i] < 0){
            i++;
        }
        i++;
        while(i < arr.length){
            if(arr[i] > arr[i-1]+1){
                return arr[i-1]+1;
            }
            i++;
        }
        if((arr[arr.length-1]) <= 0){
            return 1;
        }
        return (arr[arr.length-1]+1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //REad the length of the array and the array itself
        System.out.print("Enter length of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the array elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        FirstMissingPositive solver = new FirstMissingPositive();
        int missing = solver.findFirstPositiveMissing(arr);
        System.out.println("First Missing Positive number: " + missing);
    }
}
