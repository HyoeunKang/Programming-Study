package codeTest;
/*�������̶�?
 * ���� �۾��� ��ȯ������ �ݺ��ϸ鼭 �Ǻ��� ���� �κ����հ� ������ �κ������� �����ϴ� ���
 * 1. ��ü ���� ��� �ϳ��� ���Ҹ� �߽�(�Ǻ�)���� 2���� �κ��������� �����Ѵ�.
 * 2. ����(�Ǻ�)���� ���� ���Ҵ� ���� �κ���������, ū ���ҵ��� ������ �κ��������� �����Ѵ�.
 * 3. ���ҵ� �κ������� ũ�Ⱑ 0�̳� 1�� �� ������ ��ȯ ȣ���� �̿��� �ٽ� �����Ѵ�.
 */
public class QuicSort {

	public static void main(String[] args) {
		//������ �迭�� quicsort�� �����غ��ÿ�.
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
		//�Ǻ��� �����ϴ� ����� 2������ �ִ�.
		//������(���� ��, ���� ���� �߾�)
		int pivot= arr[(left+right)/2]; //��, arr[pivot]���� ����.
		System.out.println("pivot:"+pivot);
		//���� ����
		while(left<right){
			System.out.println("=========================");
			while((arr[left]<pivot)&&(left<right)) {//���� �κ����� ����
				System.out.println("����ϴ� left:"+left);
				left++;			
			}			
			while((arr[right]>pivot&&(left<right))) {//������ �κ����� ����
				System.out.println("����ϴ� right:"+right);
				right--;
			}
			System.out.println("���� left:"+left);//���ߴ� �κ��� arr[left]>pivot�̱� �����̴�!!
			System.out.println("���� right:"+right);//���ߴ� �κ��� arr[left]>pivot�̱� �����̴�!!
			
			if(left<right){//���� left�� arr[pivot]<left�̱� ������ ���������� �ڸ� �̵�
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
