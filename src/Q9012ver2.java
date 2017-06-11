import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9012ver2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine().trim());//공백을 제거한 카운트 값 받기
		
		for(int i=0; i<cnt; i++){
			String input = br.readLine().trim(); //공백을 제거한 괄호 문자열 받기
			Stack<Character> check = new Stack<Character>(); //char형만 받는 스택 생성
			for(int j=0; j<input.length(); j++){
				char c = input.charAt(j);
				switch(c){
				case '('://'('라는 애를 만나면 스택에 집어넣어!
					check.add(c);
					break;
				case ')':
					if(check.isEmpty()){//기저사례. 아무것도 없는 상태에서 ')'가 나온다면 잘못된 표현임
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
