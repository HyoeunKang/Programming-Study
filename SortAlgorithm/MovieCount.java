package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MovieCount {

	static Map<String, Integer> result = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		System.out.println("movies 배열은 오늘 하루 영화 예매 순서이다. \n 누적횟수가 많은 영화부터 출력하라."
				+ "단, 동일한 순위는 오름차순으로 출력한다.");
		
		String[] movies = {"미이라", "스파이더맨", "용의자","미이라","악녀","악녀","하루","스파이더맨","악녀"};
		solution(movies);
	}
	static void solution(String[] movies){
			int count=-1;
			while(++count<movies.length){			
				String title = movies[count];
				if(result.containsKey(movies[count])){
					result.put(title, result.get(title).intValue()+1);
				}else{
					result.put(title, 1);
				}
			}
			/*//HashMap에 데이터를 정렬할 때 key 정렬이 되지 않기 때문에 
			//key를 정렬하려면 기본 오름차순으로 정렬하는 TreeMap에 정렬할 수 있다.
			TreeMap<String, Integer> tm = new TreeMap<String,Integer>(result);
			
			Set<String> getResult = tm.keySet();
			Iterator<String> ite = getResult.iterator();
			while(ite.hasNext()){
				String title = (String) ite.next();
				System.out.println(title+", "+tm.get(title));
			}*/
			Iterator<String> ite = MovieCount.sortByValue(result).iterator();
			  while(ite.hasNext()){

		            String temp = ite.next();

		            System.out.println(temp + " = " + result.get(temp));

		        }
		}
	public static List<String> sortByValue(final Map<String, Integer> map){

        List<String> list = new ArrayList<String>();

        list.addAll(map.keySet());



        Collections.sort(list,new Comparator<Object>(){

			@SuppressWarnings("unchecked")

			public int compare(Object o1,Object o2){

                Object v1 = map.get(o1);

                Object v2 = map.get(o2);

                 

                return ((Comparable<Object>) v1).compareTo(v2);

            }

        });

        Collections.reverse(list); // 주석시 오름차순

        return list;

    }

}
