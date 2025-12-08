/*
LeetCode 1925: Count Square Sum Triples 
A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

Example 1:
Input: n = 5
Output: 2
Explanation: The square triples are (3,4,5) and (4,3,5).

Example 2:
Input: n = 10
Output: 4
Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
*/
import java.util.*;
public class CountSquareSumTrips {
    static int countTriples(int n) {
        int ans = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                double sqrtNum = Math.sqrt(i*i + j*j);
                if(sqrtNum == (int)sqrtNum && sqrtNum <= n){
                    ans += 2;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int ans = countTriples(n);
        System.out.println("Number of triplets = " + ans);
        sc.close();
    }
}