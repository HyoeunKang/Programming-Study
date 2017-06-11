import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
	static int t;
	static int n, m;
	static int index;
	static Queue<Integer> q;
	static int count;
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());//테스트케이스
		
		for(int i=0; i<t; i++){
			count=1;
			st = new StringTokenizer(br.readLine());//한줄 띄우고
			n = Integer.parseInt(st.nextToken());//문서의 갯수
			index = Integer.parseInt(st.nextToken());//찾는 문서의 위치
			
				//큐에 가중치가 들어있다.
				q = new LinkedList<Integer>();
				st = new StringTokenizer(br.readLine());				
				for(int j=0; j<n; j++){					
					q.offer(Integer.parseInt(st.nextToken()));
				}
				index = (int) q.toArray()[index];
				//System.out.println("찾는 문서의 중요도:"+index);
				
				doSwap(q);
		}
		
	}
	static void doSwap(Queue<Integer> q){
		
		while(true){
			/*
			 * 현재 헤드에 있는 값과 그 다음 값을 검사한다.
			 * 만일, 헤드 값이 작을 경우 헤드값은 다시 큐 뒤로 보낸다.
			 * 이렇게 검사해서 가장 큰 값을 찾아 내보낸 뒤 count를 체크한다.
			 * 즉, count가 해당 문서가 몇번째로 인쇄되는지 알아내는 것이다.
			 * 단, 특이한 점이 있다면 각 원소마다 번호가 있어야 한다는 것이다. 
			 */
			if(n==1) {
				System.out.println(1);
				break;
			}
			int target = q.poll();			
			int next = q.peek();
			if(target<next){
				q.offer(target);
				//System.out.println("바뀐 후 현재 해드의 정보:"+q.peek());
				continue;
			}else{				
				if(target==index){
					System.out.println(count);
					break;
				}
				count++;
			}
		}
	}
}
