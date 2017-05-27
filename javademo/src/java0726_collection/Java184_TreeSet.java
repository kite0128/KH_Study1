package java0726_collection;

import java.util.Iterator;
import java.util.TreeSet;

public class Java184_TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(new Integer(10));
		tree.add(new Integer(20));
		tree.add(new Integer(15));
		tree.add(new Integer(20));

		System.out.println("오름차순");
		//오름차순으로..
		Iterator<Integer> ite = tree.iterator();
		
		while(ite.hasNext())
			System.out.println(ite.next());
		
		System.out.println("내림차순");
		//내림차순으로..
		ite=tree.descendingIterator();
		while(ite.hasNext())
			System.out.println(ite.next());
	}

}
