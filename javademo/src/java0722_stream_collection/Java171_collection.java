package java0722_stream_collection;

import java.util.Vector;

class Person {
	String name;
	int age;

	public Person() {

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "  " + age;
	}

}

public class Java171_collection {

	public static void main(String[] args) {
		/*
		 * Person p1 = new Person("홍길동",30); Person p2 = new Person("이영희",25);
		 */
		
		/*Person[] arr = new Person[2];
		arr[0] = new Person("홍길동", 30);
		arr[1] = new Person("이영희", 25);*/
		
		Vector<Person> v = new Vector<Person>();
		v.addElement(new Person("홍길동",30));
		v.addElement(new Person("이영희",25));
		
		for(Person pn : v)
			System.out.printf("%s\n", pn.toString());
	}

}
