package java0805_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java0805_jdbc.dao.EmployeesDAO;
import java0805_jdbc.dto.EmployeesDTO;

class DesignTest extends JFrame implements ActionListener, MouseListener{
	JTextField inputTxt;
	JButton searchBtn;
	JTable table;
	DefaultTableModel model;
	
	public DesignTest(){
		
		
		inputTxt = new JTextField(20);
		searchBtn = new JButton("검색");
		//다른 곳에서 쓰일 경우가 없고 이 생성자 안에서만 쓰이기 때문에.. JPanel은 여기다 쓴다. 멤버변수는 다른 곳에서도 공통적으로 쓰일 경우에 쓴다.
		JPanel jp = new JPanel();
		jp.add(inputTxt);
		jp.add(searchBtn);
		
		//테이블 헤드
		Object[] obj={"사원번호","사원명","급여","부서번호"};
		model = new DefaultTableModel(obj,0){
			
			//셀 편집 불가능
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
				
			}
		};
		
		table=new JTable(model);
		
		//컬럼이동 불가능
		table.getTableHeader().setReorderingAllowed(false);
		//라인의 높이
		table.setRowHeight(20);
		
		add(BorderLayout.NORTH, jp);
		add(BorderLayout.CENTER, new JScrollPane(table));
		
		//이벤트 리스너 연결
		searchBtn.addActionListener(this);
		searchBtn.addMouseListener(this);
		inputTxt.addActionListener(this);
		
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = inputTxt.getText();
		EmployeesDAO dao = EmployeesDAO.getInstance();
		
		ArrayList<EmployeesDTO> aList = dao.listMethod(str);
		
		for(EmployeesDTO emdto : aList){
			Vector<Object> ob = new Vector<Object>();
			ob.addElement(emdto.getEmployee_id());
			ob.addElement(emdto.getFirst_name());
			ob.addElement(emdto.getSalary());
			ob.addElement(emdto.getDepartment_id());
			model.addRow(ob);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*Object obj = e.getSource();
		if(obj == )*/
		
	}

	//마우스 들어갈때
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == searchBtn){
			searchBtn.setText("Search");
		}
		
	}

	//마우스 나갈때
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == searchBtn){
			searchBtn.setText("등록");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

public class Java212_gui {

	public static void main(String[] args) {
		new DesignTest();
	}

}
