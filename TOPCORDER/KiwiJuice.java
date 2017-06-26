import java.util.Arrays;

public class KiwiJuice {

	public static void main(String[] args) {
		int[] capacities={700000,800000,900000,1000000};
		int[] bottles = {478478,478478,478478,478478};
		int[] fromId={2,3,2,0,1};
		int[] toId={0,1,1,3,2};
		
		System.out.println(Arrays.toString(thePouring(capacities, bottles, fromId, toId)));
	}
	public static int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){
		for(int i=0; i<fromId.length; i++){
			int f = fromId[i];
			int t = toId[i];
			
			/*if((bottles[t]+bottles[f])<=capacities[t]){
			bottles[t] += bottles[f];
			bottles[f] = 0;
		}else{
			bottles[f] -= (capacities[t]-bottles[t]);
			bottles[t] = capacities[t];				
		}	이 조건문을 줄여보자. */
			
			//즉, toId[i]에 들어갈 양은 다음과 같이 정할 수 있다.
			//주입양<=보틀의 여유일 경우 
			//주입양>보틀의 여유일 경우
			
			//vol에는 더 작은값이 들어갈 것이다.
			int vol = Math.min(bottles[f], capacities[t]-bottles[t]);
			System.out.println("vol: "+vol);
			bottles[f] -= vol; //bottles[f]가 담기거나, 옮겨간 양(capacities[t]-bottles[t])만큼 담길 것이다.
			bottles[t]+=vol;
			
		}
		return bottles;
	}
}
