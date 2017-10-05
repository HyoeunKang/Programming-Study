import java.util.Scanner;
//Q14503
class Point2{
	int x=0 ,y=0 ,d=0;
	Point2(){}
	
	Point2(int x, int y, int d) {
		this.x=x;
		this.y=y;
		this.d=d;
	}
}

public class RobotClean2_nonre {
	static int[] dx={-1,0,1,0};
	static int[] dy={0,1,0,-1};
	//static int[] d={0,1,2,3};//N,E,S,W
	static int[][] map;
	static boolean[][] isCleand;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		
		map = new int[n][m];
		isCleand=new boolean[n][m];
		
		int x=sc.nextInt();
		int y = sc.nextInt();
		int direct = sc.nextInt();
		
		Point2 point = new Point2(x, y, direct);
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				map[i][j]=sc.nextInt();
			}
		}
		sc.close();
		//로봇청소기 작동 시작
		cleaning(point);
	
		int count=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(isCleand[i][j]+"' '");
				if(isCleand[i][j]) count++;
			}
			System.out.println();
		}
		System.out.println(count);
	}
	static void cleaning(Point2 p){
		Point2 cleanPoint = new Point2();
		//초기화
		cleanPoint.x = p.x;
		cleanPoint.y = p.y;
		cleanPoint.d = p.d;
		
		//후진여부
		boolean isBack=false;
	
		while(true){
			System.out.println();
			//현재 지점 청소
			if(isBack==false){
				isCleand[cleanPoint.x][cleanPoint.y]=true;			
				System.out.println("현재 지점 청소:"+cleanPoint.x+","+cleanPoint.y+","+cleanPoint.d);
			}
			isBack=false;
				//후진을 위한 임시 저장소
		int temp_d = cleanPoint.d;
		int temp_x = cleanPoint.x;
		int temp_y = cleanPoint.y;

			//다음 방향 설정
			cleanPoint.d=(cleanPoint.d+3)%4;
			
			//청소하지 않은 공간인지 검사
			int nx=cleanPoint.x+dx[cleanPoint.d], ny=cleanPoint.y+dy[cleanPoint.d];
			if(nx>0&&nx<=n-2&&ny>0&&ny<=m-2
					&&(map[nx][ny]==0&&isCleand[nx][ny]==false)){
				cleanPoint.x=nx; cleanPoint.y=ny; 
				continue;//청소하지 않은 공간이면 청소하러감
			}
			int count=0;
			boolean check = false;
			System.out.println("청소할 좌표를 못찾음: "+cleanPoint.x+","+cleanPoint.y+","+cleanPoint.d);
			while(count++<3){//왼쪽 영역 찾을때까지, 원래상태로 돌아오기 전 까지
				//다음 방향 설정
				cleanPoint.d=(cleanPoint.d+3)%4;
				//청소하지 않은 공간인지 검사
				nx=cleanPoint.x+dx[cleanPoint.d]; ny=cleanPoint.y+dy[cleanPoint.d];
				System.out.println("탐색할 좌표:"+nx+","+ny);
				if(nx>0&&nx<n-1&&ny>0&&ny<m-1
						&&(map[nx][ny]==0&&isCleand[nx][ny]==false)){
					cleanPoint.x=nx; cleanPoint.y=ny; 
					check=true;
					break;//청소하지 않은 공간이면 청소하러감
				}
			}
		
			if(check==true) continue;	
			else{
			System.out.println("후진 탐색 시작합니다.");
			System.out.println("후진할 좌표 준비:"+temp_x+","+temp_y+","+temp_d);
			//네 방향에 청소할 공간이 없음
			//현재 위치에서 후진할 공간 찾기
		
				switch(temp_d){
					case 0://현재 북쪽을 보고 있음
							 temp_x+=1;
							 break;
						case 1://현재 동쪽을 보고 있음
							temp_y-=1;
							break;
						case 2://현재 남쪽을 보고 있음
							temp_x-=1;
							break;
						case 3://현재 서쪽을 보고 있음
							temp_y+=1;
							break;			
				}
				//후진이 가능한 경우
				//청소 안 한 칸 나올때까지 후진~
				if(!((1>temp_x||temp_x>n-2)||(1>temp_y||temp_y>m))&&
						(map[temp_x][temp_y]==0)) {
					cleanPoint.x = temp_x;
					cleanPoint.y = temp_y;
					System.out.println("후진할 좌표:"+cleanPoint.x+","+cleanPoint.y+","+temp_d);
					continue;
				}else{//후진이 불가능한 경우
					break;
				}	
			}
		}
	}
}