/*
Bill Zheng
Time: around 2.5 hours
USACO Test Cases: *!!!!!*!tt
1-10 Difficulty: 7 super hard to code but I think the method I was doing was easy to figure out
Reflection: The coding was way too complex so I needed to look at the solution to find the easiest method of coding it.
	I tried editting the code but it never worked out so I just looked at the solution. This code below is incomplete.
	
	The idea for the code was to use up all of the gallons to sell to stores in order to find profit gained only by stores. Then calculate
	the additional profit earned if you take one cow away from a store and rent it out. Continue this until the highest profit is achieved.
 */

import java.io.*;
import java.util.*;

class Store implements Comparable <Store>{
	public int gal, cents, taken;
	public Store(int gal, int cents) {
		this.gal = gal;
		this.cents = cents;
		this.taken = 0; //gallons taken/used by the store
	}
	public int compareTo(Store g) {
		return cents - g.cents;
	}
}

public class rental_1801_silver {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("D:\\eclipse-workspace\\USACO\\Silver\\testSilver.txt"));
		//Scanner scan = new Scanner (new File ("rental.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt(); int M = scan.nextInt(); int R = scan.nextInt();
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = scan.nextInt();
		}
		Arrays.sort(cows);
		for (int i = 0; i < N; i++) {
			System.out.println("Cow i gallons: " + cows[i]);
		}
		
		Store[] stores = new Store[M];
		for (int i = 0; i < M; i++) {
			stores[i] = new Store(scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(stores);
		
		for (int i = 0; i < M; i++) {
			System.out.println("Gal: " + stores[i].gal + "; Cents: " + stores[i].cents);
		}
		
		
		int[] farmers = new int[R];
		for (int i = 0; i < R; i++) {
			farmers[i] = scan.nextInt();
		}
		Arrays.sort(farmers);
		
		for (int i = 0; i < R; i++) {
			System.out.println("Farmer i price: " + farmers[i]);
		}
//--------------------------------------------------------------------------------------------------------------------------
		int totalgal = 0; //total milk in gallons
		int storemax = 0;
		int index = M-1;
		int c = 0;
		
		for (int i = 0; i < N; i++) {
			totalgal += cows[i];
		}
		for (int i = 0; i < M; i++) {
			storemax += stores[i].gal;
		}
		
		int profit = 0;
		int gals = totalgal;
		
		if (totalgal <= storemax) {
			gals = totalgal;
			for (int i = M-1; i >= 0; i--) {
				if (gals >= stores[i].gal) {
					profit += stores[i].gal*stores[i].cents;
					gals -= stores[i].gal;
					stores[i].taken = stores[i].gal;
					System.out.println("stores[i].taken: " + stores[i].taken);
				} 
				else if (gals < stores[i].gal){
					profit += gals*stores[i].cents;
					stores[i].taken = gals;
					gals = 0;
					System.out.println("stores[i].taken: " + stores[i].taken);
				}
				
				if (gals <= 0) {
					index = i;
					break;
				}
			}
		} else {
			//gals = totalgal;
			//c = 1;
			
			for (int i = 1; i <= M; i++) {
				if (cows[N-i])
				
				
				if (gals >= stores[i].gal) {
					profit += stores[i].gal*stores[i].cents;
					gals -= stores[i].gal;
					stores[i].taken = stores[i].gal;
					System.out.println("stores[i].taken: " + stores[i].taken);
				} 
			}
		}
		
		System.out.println("Profit: " + profit);
//--------------------------------------------------------------------------------------------------------------------------
		int ret = profit;
		int total = 0;
		int less = Math.min(R, N);
		for (int i = 0; i < less; i++) { //check middle condition/parameter, not always the same
			total = 0;
			System.out.println("i: " + i + "; index: " + index);
			//calculate everything here first
			
			int g = cows[i];
			System.out.println("i: " + i + "; cows[i]: " + g);
			System.out.println("i: " + i + "; stores[index].taken: " + stores[index].taken);
			while (g > stores[index].taken) {
				total += stores[index].taken*stores[index].cents;
				g -= stores[index].taken;
				stores[index].taken = 0;
				index++;
			}
			total += g*stores[index].cents;
			stores[index].taken -= g;
			//g = 0;
			
			
			System.out.println("i: " + i + "; farmers[R-1-i]: " + farmers[R-1-i]);
			System.out.println("i: " + i + "; total: " + total);
			profit += farmers[R-1-i];
			profit -= total;
			System.out.println("i: " + i + "; profit: " + profit);
			if (profit < ret) {
				break;
			} else ret = profit;
		}
//--------------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		System.out.println(ret);
		out.println(ret);

		out.close();
		scan.close();
	}
}
