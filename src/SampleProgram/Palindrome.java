package SampleProgram;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		/*
		 * Scanner t=new Scanner(System.in); String st=t.nextLine(); String temp="";
		 * for(int i=st.length()-1;i>=0;i--) { temp+=st.charAt(i); } if(st.equals(temp))
		 * { System.out.println("Yes"); }else { System.out.println("No"); }
		 */
		//--------------------------------------
		  Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // Number of children
        int[] candies = new int[n];

        // Input the initial candies each child has
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        int[] minCandies = new int[n];
        minCandies[0] = 1; // Rahul gives 1 candy to the first child

        // Calculate minimum candies for each child
        for (int i = 1; i < n; i++) {
            if (candies[i] > candies[i - 1]) {
                minCandies[i] = minCandies[i - 1] + 1;
            } else {
                minCandies[i] = 1;
            }
        }

        int totalMinCandies = 0;
        for (int i = 0; i < n; i++) {
            totalMinCandies += minCandies[i];
        }

        System.out.println("Total minimum candies distributed by Rahul: " + totalMinCandies);
	}
	

}
