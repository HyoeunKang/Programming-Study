package codeTest;
//문자열안에 있는 단어 뒤집기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/9093
public class reverseWord {

	public static void main(String[] args)  throws IOException{
	/*	String str ="do or do not. there is no try";
		String result="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(str);
		while(true){
			String temp =st.nextToken();
			if(temp==null) break;
			result+=temp+" ";
			System.out.println(result);
		}
		System.out.println(result);*/
		
		//1. 문자열을 모두 뒤집는다.
		//2. 단어들을 다시 뒤집는다.
		String str ="do or do not. there is no try";
		String temp = str;
		temp=reverseStr(temp);
		System.out.println(temp);
	}
	static String reverseStr(String str){
		int start=0,end=str.length()-1;
		char temp;
		while(end>start){
			temp=str.charAt(start);
			str.charAt(start)=str.cha
			--end;++start;
		}
		return str;
	}
}
