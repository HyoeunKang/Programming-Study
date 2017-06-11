package is0610;

import java.util.Scanner;

/*
 * 1로 만들기
 * - 정수 N이 주어졌을 때, 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값?
 * - 다이나믹 프로그래밍으로 계산 결과를 저장한다.
 	- 다이나믹 프로그래밍의 결과 값은 dp[n]에 저장되어 진다.
 */
public class Q1463 {
	static int n;
	static int dp[];//n번까지 연산을 저장할 배열을 만든다. DP의 기본 재료는 배열!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		dp = new int[n+1];
		//일차원 배열 다이나믹 프로그래밍의 의미:
		/* dp[n]의 의미는, n번까지 왔을 때 목표값을 의미한다.
		 * 예를 들어 n까지 오는 최소 횟수, 최대 횟수, 최소 비용, 최대 비용 등을 의미할 수 있다.
		 * 
		 * dp[n]에 도달하기 위해서는 dp[0]부터 점차적으로 비용을 누적해서 가져와야 한다.
		 * 단, 주의할 점이 있다면 문제에 따라 dp[0]과 dp[1]의 값이 0으로 지정되는 경우가 많다.
		 * 따라서 초기화가 중요하다.
		 * 
		 * 다음으로는 점화식을 세우는 것이 중요하다.
		 * dp의 꽃은 점화식이다. 
		 * 
		 */
		System.out.println(doDynamic(n));
	}
	
	static int doDynamic(int n){
		dp[0]=0;
		dp[1]=0;
		
		for( int i=2; i<=n; i++){
			dp[i] = dp[i-1]+1; //만일, 횟수를 구하는 문제일 경우 현재 횟수는 이전 횟수에서 +1이 된 값임을 기억한다.
			
			if(i%2==0){//먼저 2로 나누어떨어지는지 검사함.
				dp[i] = Math.min(dp[i], dp[i/2]+1);//나누어 떨어진다면, 현재 dp[i]에 있는 값과 비교함. 더 적은 횟수가 dp에 적힘
			}
			if(i%3==0){//다음으로 3으로 나누어떨어지는지 검사함. 왜냐하면 i%2일 때보다 값이 더 작을 수도 있으니깐.
				dp[i] = Math.min(dp[i], dp[i/3]+1);//나누어 떨어진다면, 현재 dp[i]에 있는 값과 비교함. 더 적은 횟수가 dp에 적힘
			}
		//	System.out.println("dp["+i+"]의 값은: "+dp[i]);
		}
	return dp[n];
	}
}
