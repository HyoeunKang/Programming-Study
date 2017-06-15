package codeTest;
//배열에서 빠진 숫자 1개 찾기
public class NotInNum {

	public static void main(String[] args) {
		int[] problem={3,1,4,5,6,8,7,9};
		int n=9;
		int sum=0;
		for(int i:problem){
			sum+=i;
		}
		if(n%2==0){System.out.println((n+1)*(n/2)-sum);}
		else{System.out.println((1+(n-1))*(n/2)+n-sum);}
		}

}
