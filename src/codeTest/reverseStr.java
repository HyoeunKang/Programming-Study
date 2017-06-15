package codeTest;
//문자열 뒤집기
public class reverseStr {

	public static void main(String[] args) {
		String str="!won ti od ot yrt";
		String result="";
		for(int i=str.length()-1; i>=0; i--){
			result+=str.charAt(i);
		}
		System.out.println(result);
		
		//StringBuffer 사용하기
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(str);
		System.out.println(strBuf.reverse());
	}

}
