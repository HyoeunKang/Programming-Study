package is0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[][] arr;
	static int n;
	static int m;
	static boolean isVisited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v =  Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		isVisited = new boolean[n+1];
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
	
		dfs(v);//dfs 시작
		
		System.out.println();
		
		for(int i=0; i<isVisited.length; i++){
			isVisited[i]=false; //BFS 돌려야하니깐 방문 초기화!
		}
		bfs(n,m,v);
	}
	static void bfs(int n, int m, int v){
		q.add(v);
		isVisited[v]=true;
		
		while(!q.isEmpty()){
			int now = q.poll();
			System.out.print(now+" ");
			
			for(int i=1; i<=n;i++){
				if(arr[i][now]==1 && isVisited[i]==false){		
					q.add(i);
					isVisited[i]=true;
				}
			}
		}
	}
	static void dfs(int v){
		int i=0;
		isVisited[v]=true; //정점 v를 방문했다고 표시
		System.out.printf(v+" ");
		for(i=1; i<=n; i++){
			//정점 v와 i가 연결되었고, 정점 i를 방문하지 않았다면
			if(arr[v][i]==1 && !isVisited[i]){
			//	System.out.printf("%d에서 %d로 이동",v,i);
				dfs(i);
			}
		}
	}
}
