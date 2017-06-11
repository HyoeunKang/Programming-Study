package is0610;

import java.util.Scanner;

/*
 * <2*n ũ���� ���簢���� 1*2, 2*1 Ÿ�Ϸ� ä��� ����� ��>
 * �����ذῡ �ʿ��� ���� : ���̳��� ���α׷���, ����� ��
 * ��� ���� ������ ������?
 * ���� �ܰ��� ���簢�� ���(i-1, i-2)�� ���ϴ� ����� ���� ����ؼ� �÷���?
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
		//���簢��. �� 2*2�� ����� dp[2]=2�� Ȯ���� �˰ԵǾ���.
		//�׷��ٸ� dp[3]���ʹ� dp[1]�� dp[2]�� ��� ���� �̷���� ���̴�.
		//��, ���� �ܰ�� �� ���� �ܰ谡 ��� �����Ǿ����Ŀ� ���� dp[i]��°�� ���� ������ ���̴�.
		if(dp[n]>0) return dp[n];
			dp[n]=(doPut(n-1)+doPut(n-2))%10007;
		
		return dp[n];
	}
}
