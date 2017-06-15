package codeTest;
/*
 * ���������� �����İ� ���������� �������� ����� ����.	
 */
public class MergeSort {
	 
    public static void print_arr (int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
    }
   
    public static void merge (int[] arrA, int[] arrB, int[] arrC) {
    	System.out.println("-----------------------------merge");
            int iA = 0;
            int iB = 0;
            int iC = 0;
           
            while (iA < arrA.length) {
                    if (iB < arrB.length) {
                            if ( arrA[iA] < arrB[iB]) {
                                    arrC[iC] = arrA[iA];
                                    System.out.println(iC+"��°�� ��� ��:"+arrC[iC]);
                                    iA++;
                            } else {
                                    arrC[iC] = arrB[iB];
                                    System.out.println(iC+"��°�� ��� ��:"+arrC[iC]);
                                    iB++;
                            }
                            iC++;
                    } else {
                            while (iA < arrA.length) {//Ŀ�� �ȹٲ�� ��������
                                    arrC[iC] = arrA[iA];
                                    System.out.println(iC+"��°�� ��� ��!!!!!:"+arrC[iC]);
                                    iA++;
                                    iC++;
                            }
                    }
            }
           
            while (iB < arrB.length) {
                    arrC[iC] = arrB[iB];
                    System.out.println("!!!!!"+iC+"��°�� ��� ��!!!!!:"+arrC[iC]);
                    iB++;
                    iC++;
            }
    }
   
    public static void merge_sort (int[] arr) {
            int n = arr.length;
           
            if (n == 1) return;
           
            int[] arr_temp1 = new int[n/2];//����-����
            int[] arr_temp2 = new int[n - n/2];//����-������
           
            for (int i = 0; i< n/2; i++) {//���Ұ� 1���� ����������
                    arr_temp1[i] = arr[i];
            }
            for (int i = 0; i< n - n/2; i++) {//���Ұ� 1���� ����������
                    arr_temp2[i] = arr[i + n/2];
            }
            System.out.print("Array S1: ");
            print_arr(arr_temp1);
            System.out.print("Array S2: ");
            print_arr(arr_temp2);
           
            merge_sort(arr_temp1);
            merge_sort(arr_temp2);
           
            merge(arr_temp1, arr_temp2, arr);//����, ������, ��ģ��
            System.out.print("----------------------------Array S: ");
            print_arr(arr);
    }
   
    public static void main (String[] args) {
            int[] arr = {85, 24, 63, 45, 17, 31, 96, 50};
            System.out.print("���� �� �迭: ");
            print_arr(arr);
            merge_sort(arr);
            System.out.print("���ĵ� �迭: ");
            print_arr(arr);
    }
}
