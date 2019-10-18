package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2 {
	static int perm_idx = 0;
	static ArrayList<String> permlist = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		Arrays.sort(input);
		perm(input, 0);
		int find_k = Integer.parseInt(br.readLine());
		System.out.print(permlist.get(find_k-1));
	}
	
	public static void perm(String[] arr, int pivot) {
		if(pivot == arr.length) {
			perm_string(arr);
			return;
		}
		
		for(int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(arr, pivot+1);
			swap(arr, i, pivot);
		}
	}
	
	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void perm_string(String[] arr) {
		String str = "";
		for(int i = 0; i < arr.length; i++) str += arr[i];
		permlist.add(str);
	}
}