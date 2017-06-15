package codeTest;

import java.math.BigInteger;

public class Oneto100 {
	
	public static void main(String[] args) {
		//1부터 100까지 더하기
		int sum=0;
		for(int i=1; i<=10; sum+=i, i++){}
		System.out.println(sum);
		
		sum=0;
		
		for(int i=1;;sum+=i, ++i){
			if(i==11) break;
		}
		System.out.println(sum);
		System.out.println(sum());
		System.out.println("recallSum:"+recallSum(100));
		System.out.println("recallSum:"+recallSum(101));
		
		//1부터 100까지 곱하기
		System.out.println(factorial(100));
		System.out.println(factorial2(100));
		System.out.println(recallMul(100));
	}
	//일반적인 방법으로 더하기
	static int sum(){
		int s=2;
		int e =101;
		int num=0;
		
		if(e%2==0){
			num += (s+e)*(e/2); //목표값이 짝수일 때 n(n+1)/2
			System.out.println("du:"+num);
		}else{
			num=(s+(e-1))*(e/2)+e;//목표값이 홀수일 때 n(1+(n-1))/2+n
			System.out.println("du2:"+num);
		}
		return num;
	}
	//재귀함수를 써서 더하기
	static int recallSum(int n){
		int sum=0;
		if(n%2==0){sum=(n+1)*(n/2);}
		else{sum = recallSum(n-1)+n;}
		return sum;
	}
	static BigInteger factorial(int n){
		BigInteger m = BigInteger.valueOf(n);
		while(--n>0){
			m = m.multiply(BigInteger.valueOf(n));
		}
		return m;
	}
	static double factorial2(int n){
		double[] dp = new double[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<n+1; i++){
			dp[i] = (double)dp[i-1]*i;
		}
		return dp[n];
	}
	static double recallMul(int n){
		//http://marobiana.tistory.com/79
		if(n<=1) return n;
		else return recallMul(n-1)*n;
	}
}