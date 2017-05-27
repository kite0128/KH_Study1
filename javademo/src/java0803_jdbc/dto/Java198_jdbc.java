package java0803_jdbc.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class Java198_jdbc {
	public static void main(String[] args) {
		
		MemDAO dao = MemDAO.getInstance();
		//dao.insertMethod(new MemDTO("김영희",25,"제주"));
		
		/*HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("num", 3);
		map.put("name", "공작");
		dao.updateMethod(map);*/
		
		//dao.deleteMethod(1);
		
		ArrayList<MemDTO> mData = new ArrayList<MemDTO>();
		mData.add(new MemDTO("first",8,"세종"));
		mData.add(new MemDTO("second",5,"세종"));
		mData.add(new MemDTO("third",3,"세종"));
		int cnt=dao.insertMethod(mData);
		System.out.println("삽입갯수 : " + cnt);
		
		ArrayList<MemDTO> aList = dao.listMethod();
		for(int i=0; i<aList.size(); i++){
			MemDTO dto = aList.get(i);
			System.out.printf("%d %s %d %s\n", dto.getNum(), dto.getName(), dto.getAge(), dto.getLoc());
		}
	}
}
