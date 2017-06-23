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
		System.out.println("movies �迭�� ���� �Ϸ� ��ȭ ���� �����̴�. \n ����Ƚ���� ���� ��ȭ���� ����϶�."
				+ "��, ������ ������ ������������ ����Ѵ�.");
		
		String[] movies = {"���̶�", "�����̴���", "������","���̶�","�ǳ�","�ǳ�","�Ϸ�","�����̴���","�ǳ�"};
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
			/*//HashMap�� �����͸� ������ �� key ������ ���� �ʱ� ������ 
			//key�� �����Ϸ��� �⺻ ������������ �����ϴ� TreeMap�� ������ �� �ִ�.
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

        Collections.reverse(list); // �ּ��� ��������

        return list;

    }

}
