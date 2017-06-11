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
		
		t = Integer.parseInt(st.nextToken());//�׽�Ʈ���̽�
		
		for(int i=0; i<t; i++){
			count=1;
			st = new StringTokenizer(br.readLine());//���� ����
			n = Integer.parseInt(st.nextToken());//������ ����
			index = Integer.parseInt(st.nextToken());//ã�� ������ ��ġ
			
				//ť�� ����ġ�� ����ִ�.
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
			 * ���� ��忡 �ִ� ���� �� ���� ���� �˻��Ѵ�.
			 * ����, ��� ���� ���� ��� ��尪�� �ٽ� ť �ڷ� ������.
			 * �̷��� �˻��ؼ� ���� ū ���� ã�� ������ �� count�� üũ�Ѵ�.
			 * ��, count�� �ش� ������ ���°�� �μ�Ǵ��� �˾Ƴ��� ���̴�.
			 * ��, Ư���� ���� �ִٸ� �� ���Ҹ��� ��ȣ�� �־�� �Ѵٴ� ���̴�. 
			 */
			if(n==1) {
				System.out.println(1);
				break;
			}
			//����� ����ִ� Pair ��ü�� ������.
			Pair p1 = q.poll();
			//���� ���� ����� �ִ� ���� ���ϱ� ���� �������� �ʰ� ������.
			Pair p2 = q.peek();
			//����, ���� p1�� value�� p2�� value���� ���ų� �۴ٸ�, p1�� �ٽ� ť�� �ڷ� ������.
			if(p1.getValue()<=p2.getValue()){
				q.offer(p1);
				System.out.println("�ٲ� �� ���� �ص��� ����:"+q.peek().getIndex());
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
