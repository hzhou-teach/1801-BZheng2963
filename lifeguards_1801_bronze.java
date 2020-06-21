/*
Bill Zheng
Time: 20 min
USACO Test Cases: **********
1-10 Difficulty: 3, harder to come up with a solution but implementation and writing was very easy.
Reflection: The only hard part was coming up with the solution and then translating the hours to an array correctly because
	it's not perfectly in line. Got all test cases in the first try.
 */

import java.io.*;
import java.util.*;

public class lifeguards_1801_bronze {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("lifeguards.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[][] shifts = new int[N][2]; //inputs lifeguards shifts into a 2D array/matrix
		for (int i = 0; i < N; i++) {
			shifts[i][0] = scan.nextInt();
			shifts[i][1] = scan.nextInt();
		}
//--------------------------------------------------------------------------------------------------------------------------
		int[] time = new int[1001]; //timeline array to track hours
		for (int i = 0; i < N; i++) {
			for (int j = shifts[i][0]; j < shifts[i][1]; j++) {
				time[j]++; //just add an "hour" for every lifeguard, count overlaps
			}
		}
		int hours = 0;
		for (int i = 0; i <= 1000; i++) {
			if (time[i] > 0) {
				hours++; //get total number of hours, disregard overlaps, only count filled hours
			}
		}
		int max = -1;
		int total = hours;
		for (int i = 0; i < N; i++) {
			hours = total;
			for (int j = shifts[i][0]; j < shifts[i][1]; j++) {
				if (time[j]-1 == 0) {
					hours--; //if removing the lifeguard makes it so that the hour is now unfilled or 0 lifeguards on duty, subtract 1 hour from the total
				}
			}
			max = Math.max(max, hours); //keep track of maximum time possible by removing 1 lifeguard
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		out.println(max);

		out.close();
		scan.close();
	}
}
