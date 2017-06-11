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
	
		dfs(v);//dfs ����
		
		System.out.println();
		
		for(int i=0; i<isVisited.length; i++){
			isVisited[i]=false; //BFS �������ϴϱ� �湮 �ʱ�ȭ!
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
		isVisited[v]=true; //���� v�� �湮�ߴٰ� ǥ��
		System.out.printf(v+" ");
		for(i=1; i<=n; i++){
			//���� v�� i�� ����Ǿ���, ���� i�� �湮���� �ʾҴٸ�
			if(arr[v][i]==1 && !isVisited[i]){
			//	System.out.printf("%d���� %d�� �̵�",v,i);
				dfs(i);
			}
		}
	}
}
