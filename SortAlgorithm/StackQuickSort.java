package Sort;

import java.util.Arrays;
import java.util.Stack;

/*
 * QuickSort�� ����͹������?
 * - ���� �Է� ������ �ڷᰡ ���ٸ� ���� �����÷ο찡 �Ͼ ���� �ִ�.
 * - �ذ�� : ��ȯ ȣ��� ����
 * 			    - ��ü������ ������ ���� �ذ�
 */
public class StackQuickSort {

	public static void main(String[] args) {
		int[] arr = {5, 2, 6, 1, 3, 4};
		QuickSort(arr,  arr.length-1);
		System.out.println("����:\t"+Arrays.toString(arr));
	}
	static void QuickSort(int[] arr, int n){
	 Stack<Integer> stack = new Stack<Integer>();
	 int first = 0;
	 int last = n;	
	 
	 stack.push(last);
	 stack.push(first);
	 
	 while(!stack.isEmpty()){
		 
		 int left = stack.pop();
		 int right = stack.pop()+1;
		 int pivot = arr[left];
		 System.out.printf("left:%d, right:%d, pivot:%d \n",left,right,pivot);
		 while(left<right){
		
			 while(arr[++left]<pivot && left<right){}
			 while(arr[--right]>pivot && left<right){}
			 
			 if(left>=right) break;
			 
			 if(arr[left]>arr[right]){
				 int temp = arr[left];
				 arr[left] = arr[right];
				 arr[right] = temp;
			 }			
		 }
		 if(pivot>arr[right]){
			 int temp = arr[first];
			 arr[first] = arr[right];
			 arr[right] = temp;
		 }
		 System.out.printf("���� �� left:%d, right:%d, pivot:%d \n",left,right,pivot);
		System.out.println(Arrays.toString(arr));
		
		if(left==right) break;
		
		 stack.push(right+1);
		 stack.push(last);
		 stack.push(right-1);
		 stack.push(0);		
		 System.out.println("----------end-----------------------");
	 }
	}
}
