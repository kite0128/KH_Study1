package java0726_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Java186_HashMap {

	public static void main(String[] args) {
		HashMap<Integer, Number> map = new HashMap<Integer, Number>();
		map.put(1, new Integer(10));
		map.put(2, new Double(4.5));
		map.put(3, new Float(2.3f));
		
		System.out.println(map.get(2));

		Set<Integer> set = map.keySet();
		Iterator<Integer> ite = set.iterator();
		while(ite.hasNext()){
			Integer key = ite.next();
			System.out.printf("%d:%s\n",key,map.get(key));
		}
	}

}
