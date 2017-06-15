package is0610;

import java.util.Scanner;

/*
 * 1�� �����
 * - ���� N�� �־����� ��, ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ�?
 * - ���̳��� ���α׷������� ��� ����� �����Ѵ�.
 	- ���̳��� ���α׷����� ��� ���� dp[n]�� ����Ǿ� ����.
 */
public class Q1463 {
	static int n;
	static int dp[];//n������ ������ ������ �迭�� �����. DP�� �⺻ ���� �迭!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		dp = new int[n+1];
		//������ �迭 ���̳��� ���α׷����� �ǹ�:
		/* dp[n]�� �ǹ̴�, n������ ���� �� ��ǥ���� �ǹ��Ѵ�.
		 * ���� ��� n���� ���� �ּ� Ƚ��, �ִ� Ƚ��, �ּ� ���, �ִ� ��� ���� �ǹ��� �� �ִ�.
		 * 
		 * dp[n]�� �����ϱ� ���ؼ��� dp[0]���� ���������� ����� �����ؼ� �����;� �Ѵ�.
		 * ��, ������ ���� �ִٸ� ������ ���� dp[0]�� dp[1]�� ���� 0���� �����Ǵ� ��찡 ����.
		 * ���� �ʱ�ȭ�� �߿��ϴ�.
		 * 
		 * �������δ� ��ȭ���� ����� ���� �߿��ϴ�.
		 * dp�� ���� ��ȭ���̴�. 
		 * 
		 */
		System.out.println(doDynamic(n));
	}
	
	static int doDynamic(int n){
		dp[0]=0;
		dp[1]=0;
		
		for( int i=2; i<=n; i++){
			dp[i] = dp[i-1]+1; //����, Ƚ���� ���ϴ� ������ ��� ���� Ƚ���� ���� Ƚ������ +1�� �� ������ ����Ѵ�.
			
			if(i%2==0){//���� 2�� ������������� �˻���.
				dp[i] = Math.min(dp[i], dp[i/2]+1);//������ �������ٸ�, ���� dp[i]�� �ִ� ���� ����. �� ���� Ƚ���� dp�� ����
			}
			if(i%3==0){//�������� 3���� ������������� �˻���. �ֳ��ϸ� i%2�� ������ ���� �� ���� ���� �����ϱ�.
				dp[i] = Math.min(dp[i], dp[i/3]+1);//������ �������ٸ�, ���� dp[i]�� �ִ� ���� ����. �� ���� Ƚ���� dp�� ����
			}
		//	System.out.println("dp["+i+"]�� ����: "+dp[i]);
		}
	return dp[n];
	}
}