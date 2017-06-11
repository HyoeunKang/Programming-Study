import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=0;
		int top=0;
		int index=0;//���� ������
		
		int n = Integer.parseInt(br.readLine().trim());//������ ����
		int stack[] = new int[n];
		
		StringBuilder sb = new StringBuilder();//append�� �̿��� ���ڿ� �����!
		while(n-->0){//n����ŭ ���� ����
			k=Integer.parseInt(br.readLine());//���ڸ� �Է¹���
			if(k>top){//������ ��ܰ����� �Է¹��� ���ڰ� Ŭ ���
				for(int i=top; i<k; i++){
					stack[index++] = i+1;
					sb.append("+\n");
				}
			}else if(stack[index-1]!=k){//k<top�̿��� ���ÿ��� ���� �������ϴµ�,
				//������ ���� 1ĭ �Ʒ��� �ƴ� �� �Ʒ��� ���� ��� �ٸ����� ��µǹǷ� ��ȿ!
				System.out.println("NO");
				return;
			}
			index--;
			sb.append("-\n");
			if(top<k){
				top=k;
			}
			
		}
		System.out.println(sb);
	}
}
