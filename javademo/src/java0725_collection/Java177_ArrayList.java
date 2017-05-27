package java0725_collection;

import java.util.ArrayList;

public class Java177_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("oracle");
		aList.add("mysql");
		aList.add("mssql");
		String[] arr = display(aList);
		for (String data : arr)
			System.out.println(data);
	}

	public static String[] display(ArrayList<String> aList) {

		/*
		 * String[] stn = new String[aList.size()]; 
		 * for(int i=0; i<aList.size(); i++)
		 *  stn[i]=aList.get(i);
		 *  return stn;
		 */

		/*
		 * String[] arr = new String[aList.size()]; 
		 * return aList.toArray(arr);
		 */

		Object[] obj = aList.toArray();
		String[] stn = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			stn[i] = (String)obj[i];
			
		}
		return stn;
	}

}
