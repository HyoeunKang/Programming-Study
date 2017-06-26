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
			
			if((bottles[t]+bottles[f])<=capacities[t]){
				bottles[t] += bottles[f];
				bottles[f] = 0;
			}else{
				bottles[f] -= (capacities[t]-bottles[t]);
				bottles[t] = capacities[t];				
			}
		}
		return bottles;
	}
}
