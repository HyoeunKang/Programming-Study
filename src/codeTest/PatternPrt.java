package codeTest;

public class PatternPrt {

	public static void main(String[] args) {
		int num = 4321;
		//�ܼ��� 4321 432 43 4 ���
		int temp=num;
		
		while(temp>0){
			System.out.println(temp);
			temp = temp/10;
		}
		System.out.println("================");
		//�ܼ��� 1 12 123 1234 ���
		temp=0;
		while(true){
			if(num==0) break;
			temp=temp*10+num%10;
			num = num/10;
			System.out.println(temp);
		}
	}

}
