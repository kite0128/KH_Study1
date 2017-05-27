package java0725_collection;

import java.util.Vector;

public class Java173_collection {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(new Integer(10));
		v.add(new Integer(20));
		v.add(new Integer(30));
		
		//1인덱스의 요소가 제거됨
		v.remove(1);
		
		//0인덱스에 40요소를 삽입.
		v.add(0, new Integer(40));
		
		for(Integer it:v)
			System.out.println(it);
		
		
		
		
		

	}

}
