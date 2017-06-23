package CH15;

import java.util.Arrays;

public class QuickSortEx {

	public static void main(String[] args) {
		int[] arr = {1,8,3,70,4,50,10,20,0,100};
		QuickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	static void QuickSort(int[] arr, int left, int right){
		if(left<right){
			int pivotLoc = partition(arr, left, right);
			QuickSort(arr,left,pivotLoc-1);
			QuickSort(arr,pivotLoc+1,right);
		}
	}
	static int partition(int[] arr, int left, int right){
		int pivot = left;
		 while(left<right){
			 while(arr[right]>arr[pivot]) right--;
			 if(left!=right){
				 int temp = arr[left];
				 arr[left] = arr[right];
				 arr[right] = temp;
			 }
		 }
		 
		return left;
	}
}
