package codeTest;
/*퀵정렬이란?
 * 분할 작업을 순환적으로 반복하면서 피봇의 왼쪽 부분집합과 오른쪽 부분집합을 정렬하는 방법
 * 1. 전체 원소 가운데 하나의 원소를 중심(피봇)으로 2개의 부분집합으로 분할한다.
 * 2. 기준(피봇)보다 작은 원소는 왼쪽 부분집합으로, 큰 원소들은 오른쪽 부분집합으로 정렬한다.
 * 3. 분할된 부분집합의 크기가 0이나 1이 될 때까지 순환 호출을 이용해 다시 분할한다.
 */
public class QuicSort {

	public static void main(String[] args) {
		//임의의 배열을 quicsort로 정렬해보시오.
		int arr[]={10,50,39,27,90,2};
		quickSort(arr,0,arr.length-1);
		
		for(int i:arr){
			System.out.println(i);
		}
	}
	static void quickSort(int[] arr, int left, int right){
		if(left<right){
			int pivotNewIndex = partition(arr, left, right);
			System.out.println("pivotNewIndex:"+pivotNewIndex);
				quickSort(arr, left, pivotNewIndex-1);
				quickSort(arr, pivotNewIndex+1,right);
		}
	}
	static int partition(int[] arr, int left, int right){
		//	int arr[]={10,50,39,27,90,2};
		//피봇을 결정하는 방법엔 2가지가 있다.
		//중위법(좌측 끝, 우측 끝의 중앙)
		int pivot= arr[(left+right)/2]; //즉, arr[pivot]값이 담긴다.
		System.out.println("pivot:"+pivot);
		//분할 진행
		while(left<right){
			System.out.println("=========================");
			while((arr[left]<pivot)&&(left<right)) {//왼쪽 부분집합 정렬
				System.out.println("통과하는 left:"+left);
				left++;			
			}			
			while((arr[right]>pivot&&(left<right))) {//오른쪽 부분집합 정렬
				System.out.println("통과하는 right:"+right);
				right--;
			}
			System.out.println("여기 left:"+left);//멈추는 부분이 arr[left]>pivot이기 때문이다!!
			System.out.println("여기 right:"+right);//멈추는 부분이 arr[left]>pivot이기 때문이다!!
			
			if(left<right){//현재 left가 arr[pivot]<left이기 때문에 오른쪽으로 자리 이동
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		System.out.println("---------------------end---");
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("---------------------end---");
		return left;
	}
}
