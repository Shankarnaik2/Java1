package SampleProgram;

public class Test1 {
	public static void main(String[] args) {
		int arr[]= {2, 6 ,3, 7, 9, 1};
		int result=9;
		int indexa=-1, indexb=-1;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==result)
				System.out.println(arr[i]+" "+arr[j]);
					indexa=i;
					indexb=j;
				}
		}
		if(indexa==-1 && indexb==-1) {
			System.out.println("not found");
			
		}else {
			System.out.println("------------------------");
			System.out.println(indexa+"+"+indexb+ "sum" +result);
		}
	}

}
