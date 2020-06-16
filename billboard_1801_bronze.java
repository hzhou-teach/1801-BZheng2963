/*
Bill Zheng
Time: 26 min
USACO Test Cases: **********
1-10 Difficulty: 2-3, how to do it was really simple
Reflection: Only difficulty was checking edge cases and looking back at my code. After first attempt I had 8/10 of the test cases passed
	and I had to go back and look through my code to find my mistakes which took another 10 min or so.
	Additionally, the code is really messy. Is there anything I can condense or are there any tips to organize my code better?
 */

import java.io.*;
import java.util.*;

public class billboard_1801_bronze {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("billboard.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int ax1 = scan.nextInt();
		int ay1 = scan.nextInt();
		int ax2 = scan.nextInt();
		int ay2 = scan.nextInt();
		
		int bx1 = scan.nextInt();
		int by1 = scan.nextInt();
		int bx2 = scan.nextInt();
		int by2 = scan.nextInt();
//--------------------------------------------------------------------------------------------------------------------------
		int area = (ax2-ax1)*(ay2-ay1);
		if (bx2 >= ax2 && bx1 <= ax1) {
			if (by1 < ay2 && by1 > ay1 && by2 > ay2) {
				area = (ax2-ax1)*(by1-ay1);
			}
			if (by2 < ay2 && by2 > ay1 && by1 < ay1) {
				area = (ax2-ax1)*(ay2-by2);
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		if (by2 >= ay2 && by1 <= ay1) {
			if (bx1 < ax2 && bx1 > ax1 && bx2 >= ax2) {
				area = (ay2-ay1)*(bx1-ax1);
			}
			if (bx2 < ax2 && bx2 > ax1 && bx1 <= ax1) {
				area = (ay2-ay1)*(ax2-bx2);
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		if (by2 >= ay2 && by1 <= ay1 && bx2 >= ax2 && bx1 <= ax1) {
			area = 0;
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		out.println(area);
		out.close();
		scan.close();
	}
}
