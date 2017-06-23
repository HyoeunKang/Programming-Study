package Sort;

import java.util.Arrays;
import java.util.Stack;

/*
 * QuickSort를 비재귀방식으로?
 * - 만일 입력 데이터 자료가 많다면 스택 오버플로우가 일어날 수도 있다.
 * - 해결법 : 순환 호출법 구현
 * 			    - 자체적으로 스택을 만들어서 해결
 */
public class StackQuickSort {

	public static void main(String[] args) {
		int[] arr = {5, 2, 6, 1, 3, 4};
		QuickSort(arr,  arr.length-1);
		System.out.println("정답:\t"+Arrays.toString(arr));
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
		 System.out.printf("정렬 후 left:%d, right:%d, pivot:%d \n",left,right,pivot);
		System.out.println(Arrays.toString(arr));
		
		if(left==right) break;
		
		//스택에 넣을 때 주의하기
		//현재 right자리가 새로운 pivot 자리이다.46~49에서 스왑을 했기 때문이다.
		 stack.push(right+1);
		 stack.push(last);
		 stack.push(right-1);
		 stack.push(0);		
		 System.out.println("----------end-----------------------");
	 }
	}
}
