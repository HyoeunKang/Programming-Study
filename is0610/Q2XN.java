package is0610;

import java.util.Scanner;

/*
 * <2*n 크기의 직사각형을 1*2, 2*1 타일로 채우는 방법의 수>
 * 문제해결에 필요한 사항 : 다이나믹 프로그래밍, 경우의 수
 * 어떻게 하위 문제로 나눌까?
 * 이전 단계의 정사각형 모양(i-1, i-2)을 구하는 경우의 수를 계속해서 늘려감?
 */
public class Q2XN {
	static int dp[];
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n+1];
		System.out.println(doPut(n));
	}
	static int doPut(int n){
	if(n<2) return 1;
		//정사각형. 즉 2*2의 방법은 dp[2]=2로 확실히 알게되었다.
		//그렇다면 dp[3]부터는 dp[1]과 dp[2]의 방법 으로 이루어질 것이다.
		//즉, 이전 단계와 그 이전 단계가 어떻게 생성되었느냐에 따라서 dp[i]번째의 값이 구해질 것이다.
		if(dp[n]>0) return dp[n];
			dp[n]=(doPut(n-1)+doPut(n-2))%10007;
		
		return dp[n];
	}
}
