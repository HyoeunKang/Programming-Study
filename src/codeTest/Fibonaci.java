package codeTest;
//피보나치 수열을 재귀함수와 DP로 표현하기
import java.util.Scanner;

public class Fibonaci {
//1 1 2 3 5 8 13 21 34...
	static int sum;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		dynamic(n);
		
		sum=0;
		System.out.println("===========");
		for(int i=1; i<10; i++){
			System.out.println(fib(i));
		}
	}

	static int fib(int n){
		if(n==1) return 1;
		if(n==2) return 1;
		return fib(n-2)+fib(n-1);
	}
	
	static void dynamic(int n){
		for(int i=1; i<n; i++){
			if(i==1 || i==2) {
					arr[i]=1;
				}else{
					arr[i]=arr[i-2]+arr[i-1];
				}
			System.out.println(arr[i]);
		}
	}
}
