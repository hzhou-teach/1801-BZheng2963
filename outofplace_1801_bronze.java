/*
Bill Zheng
Time: 36 min
USACO Test Cases: **********
1-10 Difficulty: 6, need to find the right solution
Reflection: Initially I forgot how to do this problem and so I was trying to work a super long method of swapping cows and checking conditions
	to see if the cow was in the right place. I did this for about 30 min until I realized it would be way to hard to check all of the edge
	cases. And so, after 30 min I decided to look back at some code I did in the past and I found the easiest method to solve the problem
	by comparing two arrays, one sorted and one not sorted. The code for the final solution took like 2 minutes to write. This entire problem
	was just me digging into a dead end and then looking back to find the correct and easiest solution.
 */

import java.io.*;
import java.util.*;

public class outofplace_1801_bronze {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("outofplace.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		for (int i = 0; i < N; i++) { //makes 2 arrays to compare later
			A[i] = scan.nextInt();
			B[i] = A[i];
		}
//--------------------------------------------------------------------------------------------------------------------------
		int swaps = 0;
		Arrays.sort(B); //one sorted array, one changed
		for (int i = 0; i < N; i++) {
			if (A[i] != B[i]) { //if the arrays are different, Bessie would swap at that point
				swaps++;
			}
		}
		swaps--; //since we're running through the entire array, we will overcount by 1 swap because Bessie's original position is out of place.
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		out.println(swaps);

		out.close();
		scan.close();
	}
}
