package SampleProgram;

import java.util.Arrays;
import java.util.HashMap;


public class Test {

	public static void main(String[] args) {
		System.out.println("java programming test");
		System.out.println("java program");
		String st="aabbbccccddd";
		HashMap<Character, Integer>mp=new HashMap<>();
		for(int i=0;i<st.length();i++) {
			char ch=st.charAt(i);
			if(mp.containsKey(ch)) {
				int k=mp.get(ch);
				k++;
				mp.put(ch,k);
			}else {
				mp.put(ch, 1);
			}
		}
for(Character key:mp.keySet()) {
	System.out.print(key+""+mp.get(key));
}
System.out.println();

//------------------------------------------------------------------------
int arr1[]= {1,3,5,6,8,9,24,55,8};
int max=Arrays.stream(arr1).max().getAsInt();
System.out.print(max);
System.out.println();
int min=Arrays.stream(arr1).min().getAsInt();
System.out.println(min);
for(int i=0;i<arr1.length;i++) {
	for(int j=i+1;j<arr1.length;j++) {
		if(arr1[i]==arr1[j]) {
			System.out.println(arr1[j]);
		}
	}
}

/*
		 * String st="madam1"; String temp=""; for(int i=st.length()-1;i>=0;i--) {
		 * temp+=st.charAt(i); }if(st.equals(temp)) { System.out.println("palindrome");
		 * }else { System.out.println("not palindrome"); }
		 */
		//String st="abcdabcde";
		/*
		 * int count=0; for(int i=0;i<st.length();i++) { if(st.charAt(i)=='a') {
		 * count++; }
		 * 
		 * } System.out.println("a word occurance"+count+"times");
		 */
		
		/*
		 * HashMap<Character, Integer>mp=new HashMap(); for(int i=0;i<st.length();i++) {
		 * char ch=st.charAt(i); if(mp.containsKey(ch)) { int k=mp.get(ch);k++;
		 * mp.put(ch, k); }else { mp.put(ch,1); } }
		 * 
		 * 
		 * for(Character key:mp.keySet()) { System.out.print(key+""+mp.get(key));
		 * 
		 * }
		 */
		/*
		 * int arr[]= {2,5,4,33,9,55}; int temp=0; for(int i=0;i<arr.length;i++) {
		 * for(int j=i+1;j<arr.length;j++) { if(arr[i]>arr[j]) { temp=arr[i];
		 * arr[i]=arr[j]; arr[j]=temp; } } } for(int i=0;i<arr.length;i++) {
		 * System.out.println(arr[i]); }
		 */
		/*
		 * int count=10; int a=0,b=1; for(int i=1;i<count;i++) {
		 * System.out.print(a+" "); int c=a+b; a=b; b=c; }
		 */
		/*
		 * String st="java is a programming language"; int count=1; String
		 * arr[]=st.split(" "); for(int i=0;i<st.length();i++) { if(st.charAt(i)==' ' &&
		 * st.charAt(i+1)!=' ') { count++; } } System.out.println(count);
		 */
		/*
		 * int a=23; boolean flag=false; for(int i=2;i<=a/2;i++) { if(a%i==0) {
		 * flag=true; break; } } if(!flag) { System.out.println("prime number"); }else {
		 * System.out.println("not prime number"); }
		 */
		/*
		 * int arr[]= {1,4,6,455,44,3,99,999}; int temp=0; int len=arr.length; for(int
		 * i=0;i<arr.length;i++) { for(int j=i+1;j<arr.length;j++) { if(arr[i]<arr[j]) {
		 * temp=arr[i]; arr[i]=arr[j]; arr[j]=temp; } } } //for(int
		 * i=0;i<arr.length;i++) { //smallest System.out.println(arr[len-1]); //second
		 * smallest System.out.println(arr[len-2]); //biggest
		 * 
		 * System.out.println(arr[0]); System.out.println(arr[1]);
		 */
		/*
		 * String st="java is programming"; String arr[]=st.split(" "); String temp="";
		 * for(int i=arr.length-1;i>=0;i--) { temp=temp+arr[i]+" "; }
		 * System.out.println(temp);
		 */
		
		String st="java is a programming launguage";
		String arr[]=st.split(" ");
		String temp="";
		String out="";
		for(int i=0;i<arr.length;i++) {
			String word=arr[i];
			
		for(int j=word.length()-1;j>=0;j--) {
			temp+=word.charAt(j);
		} 
		
		out+=temp+" ";
		}
		System.out.print(out);
	}}

