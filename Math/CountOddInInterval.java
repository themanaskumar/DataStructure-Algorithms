/*
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Example 1:
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:
Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].
*/
import java.util.*;
public class CountOddInInterval {
    static int countOdds(int low, int high){
        int count = 0;
        int range = high-low+1;
        if(range % 2 == 0){
            count = range/2;
        }else if((range %2 == 1) && (low % 2 == 1) && (high % 2 == 1)){
            count = (range/2) + 1;
        }else if((range %2 == 1) && (low % 2 == 0) && (high % 2 == 0)){
            count = (range/2);
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the low and high: ");
        int low = sc.nextInt();
        int high = sc.nextInt();
        int numOdds = countOdds(low, high);
        System.out.println("Odd numbers in the range: " + numOdds);
        sc.close();
    }
}
