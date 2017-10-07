import java.util.Arrays;
import java.util.Scanner;

public class Q14501 {
	static int N;//일할 수 있는 기간
	static int[] T,P; //T 소요일, P보상
	static int[] dp; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		T=new int[N+1];
		P=new int[N+1];
		
		dp=new int[N+1];
		
		for(int i=1; i<=N; i++) {
			T[i]=sc.nextInt();
			P[i]=sc.nextInt();
			if(i+T[i]-1<=N)	dp[i]=P[i];
		}
		System.out.println(Arrays.toString(dp));
			System.out.println(dp());
			System.out.println(Arrays.toString(dp));
	}
	static int dp() {
		
		for(int i=2; i<=N; i++) {//작업물 순서
			for(int j=1; j<i; j++) {//작업기간, i를 넘는 작업기간은 생각하지 않음
				if(i+T[i]-1<=N) {
					if(i-j>=T[j]) {
							dp[i]=Math.max(dp[i], dp[j]+P[i]);
						}
				}
				else continue;
			}				
		}
		int max=dp[0];
		for(int i=1; i<=N; i++) {			
				if(max<dp[i])
					max=dp[i];
		}
		return max;
	}
}
