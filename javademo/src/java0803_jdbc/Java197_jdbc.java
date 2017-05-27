package java0803_jdbc;

import java.util.ArrayList;

public class Java197_jdbc {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		ArrayList<DepartmentDTO> aList = dao.listMethod();
		for(int i=0; i<aList.size(); i++){
			DepartmentDTO dto = aList.get(i);
			//int department_id = dto.getDepartment_id();
			System.out.printf("%d %s %d %d\n", 
					dto.getDepartment_id(), 
					dto.getDepartment_name(), 
					dto.getManager_id(), 
					dto.getLocation_id());
		}
	}

}
