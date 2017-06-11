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
		
		t = Integer.parseInt(st.nextToken());//�׽�Ʈ���̽�
		
		for(int i=0; i<t; i++){
			count=1;
			st = new StringTokenizer(br.readLine());//���� ����
			n = Integer.parseInt(st.nextToken());//������ ����
			index = Integer.parseInt(st.nextToken());//ã�� ������ ��ġ
			
				//ť�� ����ġ�� ����ִ�.
				q = new LinkedList<Integer>();
				st = new StringTokenizer(br.readLine());				
				for(int j=0; j<n; j++){					
					q.offer(Integer.parseInt(st.nextToken()));
				}
				index = (int) q.toArray()[index];
				//System.out.println("ã�� ������ �߿䵵:"+index);
				
				doSwap(q);
		}
		
	}
	static void doSwap(Queue<Integer> q){
		
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
			int target = q.poll();			
			int next = q.peek();
			if(target<next){
				q.offer(target);
				//System.out.println("�ٲ� �� ���� �ص��� ����:"+q.peek());
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
