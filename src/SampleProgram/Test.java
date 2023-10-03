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

//------------------------------------------------------------------------
//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


	}

}
