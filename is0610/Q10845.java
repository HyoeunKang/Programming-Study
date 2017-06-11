package is0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10845
 * 
 * push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
 */
public class Q10845 {
	static Queue<Integer> q;
	static int cmd;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		cmd = Integer.parseInt(st.nextToken());
		q = new LinkedList<Integer>();
		
		for(int i=0; i<cmd; i++){
			 st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("push")){
				q.offer(Integer.parseInt(st.nextToken()));
			}else if(command.equals("pop")){
				if(!q.isEmpty()){
					System.out.println(q.poll());
				}else System.out.println("-1"); 
			}else if(command.equals("size")){
				System.out.println(q.size());
			}else if(command.equals("empty")){
				if(q.isEmpty()){
					System.out.println(1);
				}else System.out.println(0);
			}else if(command.equals("front")){
				if(!q.isEmpty()){
					System.out.println(q.toArray()[0]);
				}else System.out.println("-1"); 
			}else if(command.equals("back")){
				if(!q.isEmpty()){
					System.out.println(q.toArray()[q.size()-1]);
				}else System.out.println("-1"); 
			}
		}
	}

}
