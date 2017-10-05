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
		//�κ�û�ұ� �۵� ����
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
		//�ʱ�ȭ
		cleanPoint.x = p.x;
		cleanPoint.y = p.y;
		cleanPoint.d = p.d;
		
		//��������
		boolean isBack=false;
	
		while(true){
			System.out.println();
			//���� ���� û��
			if(isBack==false){
				isCleand[cleanPoint.x][cleanPoint.y]=true;			
				System.out.println("���� ���� û��:"+cleanPoint.x+","+cleanPoint.y+","+cleanPoint.d);
			}
			isBack=false;
				//������ ���� �ӽ� �����
		int temp_d = cleanPoint.d;
		int temp_x = cleanPoint.x;
		int temp_y = cleanPoint.y;

			//���� ���� ����
			cleanPoint.d=(cleanPoint.d+3)%4;
			
			//û������ ���� �������� �˻�
			int nx=cleanPoint.x+dx[cleanPoint.d], ny=cleanPoint.y+dy[cleanPoint.d];
			if(nx>0&&nx<=n-2&&ny>0&&ny<=m-2
					&&(map[nx][ny]==0&&isCleand[nx][ny]==false)){
				cleanPoint.x=nx; cleanPoint.y=ny; 
				continue;//û������ ���� �����̸� û���Ϸ���
			}
			int count=0;
			boolean check = false;
			System.out.println("û���� ��ǥ�� ��ã��: "+cleanPoint.x+","+cleanPoint.y+","+cleanPoint.d);
			while(count++<3){//���� ���� ã��������, �������·� ���ƿ��� �� ����
				//���� ���� ����
				cleanPoint.d=(cleanPoint.d+3)%4;
				//û������ ���� �������� �˻�
				nx=cleanPoint.x+dx[cleanPoint.d]; ny=cleanPoint.y+dy[cleanPoint.d];
				System.out.println("Ž���� ��ǥ:"+nx+","+ny);
				if(nx>0&&nx<n-1&&ny>0&&ny<m-1
						&&(map[nx][ny]==0&&isCleand[nx][ny]==false)){
					cleanPoint.x=nx; cleanPoint.y=ny; 
					check=true;
					break;//û������ ���� �����̸� û���Ϸ���
				}
			}
		
			if(check==true) continue;	
			else{
			System.out.println("���� Ž�� �����մϴ�.");
			System.out.println("������ ��ǥ �غ�:"+temp_x+","+temp_y+","+temp_d);
			//�� ���⿡ û���� ������ ����
			//���� ��ġ���� ������ ���� ã��
		
				switch(temp_d){
					case 0://���� ������ ���� ����
							 temp_x+=1;
							 break;
						case 1://���� ������ ���� ����
							temp_y-=1;
							break;
						case 2://���� ������ ���� ����
							temp_x-=1;
							break;
						case 3://���� ������ ���� ����
							temp_y+=1;
							break;			
				}
				//������ ������ ���
				//û�� �� �� ĭ ���ö����� ����~
				if(!((1>temp_x||temp_x>n-2)||(1>temp_y||temp_y>m))&&
						(map[temp_x][temp_y]==0)) {
					cleanPoint.x = temp_x;
					cleanPoint.y = temp_y;
					System.out.println("������ ��ǥ:"+cleanPoint.x+","+cleanPoint.y+","+temp_d);
					continue;
				}else{//������ �Ұ����� ���
					break;
				}	
			}
		}
	}
}