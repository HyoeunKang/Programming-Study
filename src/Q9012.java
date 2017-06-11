import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9012 {
	static int n;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++){
			count=0;
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			String[] cmdSplit = cmd.split("");
			
			for(int j=0; j<cmdSplit.length; j++){
				if(cmdSplit[j].equals("(")){
					count++;
				}else{
					count--;
				}
				if(count==-1){
					break;
				}
			}
			if(count==0){
			System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
