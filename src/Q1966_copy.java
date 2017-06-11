import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
	private int index;
	private int value;
	
	Pair(){}
	
	Pair(int i, int v){
		this.index = i;
		this.value = v;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
public class Q1966_copy {
	static int t;
	static int n, m;
	static int index;
	static Queue<Pair> q;
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
				q = new LinkedList<Pair>();
				st = new StringTokenizer(br.readLine());				
				
				for(int j=0; j<n; j++){					
					int val =Integer.parseInt(st.nextToken());
					q.offer(new Pair(j, val));
				}
	
				doSwap(q);
		}
		
	}
	static void doSwap(Queue<Pair> q){
		
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
			//헤더에 들어있는 Pair 객체를 꺼낸다.
			Pair p1 = q.poll();
			//새로 생긴 헤더에 있는 값과 비교하기 위해 삭제하진 않고 꺼낸다.
			Pair p2 = q.peek();
			//만일, 꺼낸 p1의 value가 p2의 value보다 같거나 작다면, p1은 다시 큐의 뒤로 보낸다.
			if(p1.getValue()<=p2.getValue()){
				q.offer(p1);
				System.out.println("바뀐 후 현재 해드의 정보:"+q.peek().getIndex());
				continue;
			}else{				
				if(p1.getIndex()==index){
					System.out.println(count);
					break;
				}
				count++;
			}
		}
	}
}
