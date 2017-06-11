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
 * push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
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
