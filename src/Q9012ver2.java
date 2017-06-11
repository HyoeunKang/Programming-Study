import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9012ver2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine().trim());//������ ������ ī��Ʈ �� �ޱ�
		
		for(int i=0; i<cnt; i++){
			String input = br.readLine().trim(); //������ ������ ��ȣ ���ڿ� �ޱ�
			Stack<Character> check = new Stack<Character>(); //char���� �޴� ���� ����
			for(int j=0; j<input.length(); j++){
				char c = input.charAt(j);
				switch(c){
				case '('://'('��� �ָ� ������ ���ÿ� ����־�!
					check.add(c);
					break;
				case ')':
					if(check.isEmpty()){//�������. �ƹ��͵� ���� ���¿��� ')'�� ���´ٸ� �߸��� ǥ����
						System.out.println("NO"); 
						break;
					}
					check.pop();
					break;
				}
			}
			if(check.isEmpty()) {System.out.println("YES");}
			else{System.out.println("NO");}
		}
		
		
	}

}
