package acmicp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int x, y;
	
	Pair(){}
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
/*
 * M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 
 * 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
 * 
 */
public class Q2583 {
/*
 * 1. 직사각형의 좌표를 받아 2차원 배열에 표시
 *  - 높이의 차, 너비의 차를 구해서 직사각형 형태 표시
 * 2. BFS 탐색
 *  - 빈 칸 탐색
 *  - 빈 칸으로부터 BFS 수행후 더 이상 방문할 수 없을때 구역탐색 종료
 *   -탐색 영역 그룹 표시 후 다시 빈 칸을 찾아 BFS 수행
 *   - 더 이상 큐에 담을 영역이 없을 때까지 수행
 * 3. 2번 과정을 통해 표시한 영역의 넓이를 구해 결과 출력
 */
	static HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
	static Queue<Pair> q = new LinkedList<Pair>();
	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};
	static int label=1;
	static int N,M;
	static int x1,x2,y1,y2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     		String[] temp = br.readLine().trim().split(" ");
		
		int K=0;

		M= Integer.parseInt(temp[0]);
		N= Integer.parseInt(temp[1]);
		K= Integer.parseInt(temp[2]);
		
		int[][] map = new int[N][M];
		
		//2차원 배열에 직사각형 표시
		for(int a=0; a<K; a++){
		    temp = br.readLine().trim().split(" ");
		    x1 = Integer.parseInt(temp[0]);
	            y1 = Integer.parseInt(temp[1]);
	            x2 = Integer.parseInt(temp[2]);
	            y2 = Integer.parseInt(temp[3]);
		
			for(int w=(x2-1); w>=x1; w--){
				for(int h=(y2-1); h>=y1; h--){
					map[w][h]=-1;
				}
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j]==0) bfs(map, i, j);
			}
		}		
		
		/*for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i])
			}
		}*/
		System.out.println(label-1);
		
		Object[] arr = result.values().toArray();
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void bfs(int[][] map, int x, int y){
	
		map[x][y]=label;
		
		result.put(label, 1);
		q.clear();
	
		q.add(new Pair(x,y));
		
		while(!qx.isEmpty()){
			int nx = qx.poll();
			int ny = qy.poll();
			
			for(int i=0; i<dx.length; i++){
				int nextx = nx + dx[i];
				int nexty = ny + dy[i];
				
				if(0<=nextx&&nextx<N&&0<=nexty&&nexty<M
						&&map[nextx][nexty]==0){
					map[nextx][nexty]=label;
					
					result.put(label, result.get(label)+1);
						q.add(new Pair(nextx, nexty));
				}
			}
		}
		label++;
	}

}
