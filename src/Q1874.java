import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=0;
		int top=0;
		int index=0;//스택 포인터
		
		int n = Integer.parseInt(br.readLine().trim());//숫자의 갯수
		int stack[] = new int[n];
		
		StringBuilder sb = new StringBuilder();//append를 이용해 문자열 만들기!
		while(n-->0){//n번만큼 연산 수행
			k=Integer.parseInt(br.readLine());//숫자를 입력받음
			if(k>top){//스택의 상단값보다 입력받은 숫자가 클 경우
				for(int i=top; i<k; i++){
					stack[index++] = i+1;
					sb.append("+\n");
				}
			}else if(stack[index-1]!=k){//k<top이여서 스택에서 값을 꺼내야하는데,
				//꺼내는 값이 1칸 아래가 아닌 더 아래에 있을 경우 다른값도 출력되므로 무효!
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
