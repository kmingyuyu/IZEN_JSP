package ch07;

public class GuGuDan {
	
	public int[] process(int n) {
		int arr[] = new int[9];
		for(int i=1; i<=9; i++) {
			arr[i=1] = n*i;
		}
		return arr;
	}
}
